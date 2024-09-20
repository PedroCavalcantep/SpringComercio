package dev.kof.Comercio.controllers;

import dev.kof.Comercio.domain.produto.Produto;
import dev.kof.Comercio.domain.produto.RequestProduto;
import dev.kof.Comercio.domain.usuario.RequestUsuario;
import dev.kof.Comercio.domain.usuario.UpdateUsuario;
import dev.kof.Comercio.domain.usuario.Usuario;
import dev.kof.Comercio.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

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

    @GetMapping("/{codUsuario}")
    public ResponseEntity<?> findUsuario(@PathVariable Integer codUsuario) {
        var usuario = repository.findById(codUsuario);

        if(usuario.isPresent()) {
            return ResponseEntity.ok(usuario);
        }else{
            return new ResponseEntity<>("Não encontrado", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/login")
    public ResponseEntity<?> findByLogin(@RequestParam String login, @RequestParam String senha) {
        var usuario = repository.findByLogin(login);

        if(usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            return ResponseEntity.ok(usuario);
        }else {
            return new ResponseEntity<>("Usuário não encontrado.", HttpStatus.NOT_FOUND);
        }
    };

    @PostMapping
    public ResponseEntity<?> registerUsuario(@RequestBody @Valid RequestUsuario data) {
        Usuario novoUsuario = new Usuario(data);
        repository.save(novoUsuario);
        return new ResponseEntity<>("Criado com sucesso!", HttpStatus.CREATED);
    }

    @PutMapping("/{codUsuario}")
    public ResponseEntity<?> updateUsuario(@PathVariable Integer codUsuario, @RequestBody @Valid UpdateUsuario data) {
        Optional<Usuario> optionalUsuario = repository.findById(codUsuario);
        if(optionalUsuario.isPresent()) {

            Usuario usuario = optionalUsuario.get();
            if(data.login() != null && !(data.login().isBlank())) {
                usuario.setLogin(data.login());
            }
            if(data.senha() != null && !(data.senha().isBlank())) {
                usuario.setSenha(data.senha());
            }
            if(data.cargo() != null && !(data.cargo().isBlank())) {
                usuario.setCargo(data.cargo());
            }

            repository.save(usuario);

            return ResponseEntity.ok(optionalUsuario);

        } else{
            return new ResponseEntity<>("Não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codUsuario}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Integer codUsuario) {
        var usuario = repository.findById(codUsuario);
        if (usuario.isPresent()) {
            repository.deleteById(codUsuario);
            return new ResponseEntity<>("Deletado com sucesso.", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Não encontrado.", HttpStatus.NOT_FOUND);
        }
    }

}
