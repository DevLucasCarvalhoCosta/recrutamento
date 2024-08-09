package pacto.recrutamento.controller;

import pacto.recrutamento.model.Usuario;
import pacto.recrutamento.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UsuarioControllerTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioController usuarioController;

    public UsuarioControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsuarios_Success() {
        List<Usuario> usuarios = List.of(new Usuario());
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> result = usuarioController.getAllUsuarios();

        assertEquals(usuarios, result);
    }

    @Test
    public void testCreateUsuario_Success() {
        Usuario usuario = new Usuario();
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario result = usuarioController.createUsuario(usuario);

        assertEquals(usuario, result);
    }

    @Test
    public void testGetUsuarioById_NotFound() {
        when(usuarioRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        ResponseEntity<Usuario> response = usuarioController.getUsuarioById(1L);

        assertEquals(404, response.getStatusCodeValue());
    }
}
