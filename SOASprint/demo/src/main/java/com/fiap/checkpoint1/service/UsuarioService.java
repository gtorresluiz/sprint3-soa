package com.fiap.checkpoint1.service;

import com.fiap.checkpoint1.model.Usuario;
import com.fiap.checkpoint1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Salvar usuário
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Autenticar usuário
    public boolean autenticar(String email, String senha) {
        return usuarioRepository.findByEmail(email)
                .map(usuario -> usuario.getSenha().equals(senha))
                .orElse(false);
    }

    // Listar todos
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Buscar por ID
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Deletar
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
