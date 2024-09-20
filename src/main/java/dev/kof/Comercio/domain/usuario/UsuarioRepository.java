package dev.kof.Comercio.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByLogin(String login);
}
