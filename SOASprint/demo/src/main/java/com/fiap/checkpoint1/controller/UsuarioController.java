package com.fiap.checkpoint1.controller;

import com.fiap.checkpoint1.dto.UsuarioDTO;
import com.fiap.checkpoint1.model.EnderecoVO;
import com.fiap.checkpoint1.model.PerfilUsuario;
import com.fiap.checkpoint1.model.Usuario;
import com.fiap.checkpoint1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Cadastro usando DTO
    @PostMapping("/register")
    public ResponseEntity<Usuario> registrar(@RequestBody @Valid UsuarioDTO dto) {
        Usuario usuario = new Usuario(
                dto.nome(),
                dto.email(),
                dto.senha(),
                PerfilUsuario.valueOf(dto.perfil().toUpperCase()), // converte String para Enum
                new EnderecoVO(dto.rua(), dto.cidade(), dto.cep()) // cria o VO
        );
        Usuario novoUsuario = usuarioService.salvar(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    // Login básico
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioDTO dto) {
        boolean autenticado = usuarioService.autenticar(dto.email(), dto.senha());
        if (autenticado) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(401).body("Email ou senha inválidos.");
        }
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        if (usuario.isPresent()) {
            usuarioService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
