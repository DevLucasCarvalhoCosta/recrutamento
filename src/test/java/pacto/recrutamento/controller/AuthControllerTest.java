package pacto.recrutamento.controller;

import pacto.recrutamento.model.Usuario;
import pacto.recrutamento.model.AuthenticationDTO;
import pacto.recrutamento.model.RegisterDTO;
import pacto.recrutamento.model.UsuarioRole;
import pacto.recrutamento.repository.UsuarioRepository;
import pacto.recrutamento.security.TokenService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import pacto.recrutamento.model.LoginResponseDTO;

import java.lang.reflect.Field;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AuthControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UsuarioRepository repository;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private AuthController authController;

    public AuthControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister_Success() {
        RegisterDTO registerDTO = new RegisterDTO("user", "password", UsuarioRole.USER); // Corrected

        when(repository.findByUsername("user")).thenReturn(null);
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");

        ResponseEntity<Void> response = authController.register(registerDTO);

        assertEquals(200, response.getStatusCodeValue());
        verify(repository, times(1)).save(any(Usuario.class));
    }

    @Test
    public void testRegister_UserAlreadyExists() {
        RegisterDTO registerDTO = new RegisterDTO("user", "password", UsuarioRole.USER); // Corrected

        when(repository.findByUsername("user")).thenReturn(new Usuario());

        ResponseEntity<Void> response = authController.register(registerDTO);

        assertEquals(400, response.getStatusCodeValue());
        verify(repository, times(0)).save(any(Usuario.class));
    }

    @Test
    public void testLogin_Success() throws Exception {
        AuthenticationDTO authenticationDTO = new AuthenticationDTO("user", "password");

        // Create a mock Usuario object
        Usuario mockUsuario = new Usuario("user", "encodedPassword", UsuarioRole.USER);

        // Use reflection to set the id field to a UUID string
        Field idField = Usuario.class.getDeclaredField("id");
        idField.setAccessible(true);
        idField.set(mockUsuario, UUID.randomUUID().toString());

        // Mock the Authentication object
        Authentication mockAuth = mock(Authentication.class);
        when(mockAuth.getPrincipal()).thenReturn(mockUsuario);

        when(authenticationManager.authenticate(any())).thenReturn(mockAuth);
        when(tokenService.generateToken(any(Usuario.class))).thenReturn("token");

        ResponseEntity<LoginResponseDTO> response = authController.login(authenticationDTO);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockUsuario.getId(), response.getBody().id()); // Assert that the ID matches
        assertEquals("token", response.getBody().token()); // Assert that the token matches
    }
}
