package com.example.mockitodemo.repository;

import com.example.mockitodemo.model.Usuario;
import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
}
