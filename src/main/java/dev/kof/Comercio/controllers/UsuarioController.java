package dev.kof.Comercio.controllers;

import dev.kof.Comercio.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<?> getUsuarios() {
        var allUsuarios = repository.findAll();
        return ResponseEntity.ok(allUsuarios);
    }
}
