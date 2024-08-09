package pacto.recrutamento.controller;

import pacto.recrutamento.model.Usuario;
import pacto.recrutamento.model.AuthenticationDTO;
import pacto.recrutamento.model.ListarUsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pacto.recrutamento.repository.UsuarioRepository;
import pacto.recrutamento.security.TokenService;
import pacto.recrutamento.model.LoginResponseDTO;
import pacto.recrutamento.model.RegisterDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO data) {
        if (this.repository.findByUsername(data.username()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = passwordEncoder.encode(data.password());

        Usuario newUsuario = new Usuario(data.username(), encryptedPassword, data.role());

        this.repository.save(newUsuario);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        // Obtenha o usuário autenticado
        Usuario usuario = (Usuario) auth.getPrincipal();

        // Gere o token
        var token = tokenService.generateToken(usuario);

        // Retorne o ID do usuário junto com o token
        return ResponseEntity.ok(new LoginResponseDTO(usuario.getId().toString(), token));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<ListarUsuarioDTO>> listarUsuarios() {
        List<ListarUsuarioDTO> usuarios = repository.findAll().stream()
                .map(usuario -> new ListarUsuarioDTO(usuario.getId(), usuario.getUsername(), usuario.getRole()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(usuarios);
    }

}
