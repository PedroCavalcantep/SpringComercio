package dev.kof.Comercio.controllers;


import dev.kof.Comercio.domain.produto.Produto;
import dev.kof.Comercio.domain.produto.ProdutoRepository;

import dev.kof.Comercio.domain.produto.RequestProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bazinga")
public class ProdutoController {

   @Autowired
   private ProdutoRepository repository;

   @GetMapping
   public ResponseEntity getAllProdutos() {
       var allProdutos = repository.findAll();
       return ResponseEntity.ok(allProdutos);
   }

   @PostMapping
   public ResponseEntity registerProduto(@RequestBody @Valid RequestProduto data) {
        Produto novoProduto = new Produto(data);
        repository.save(novoProduto);
        return ResponseEntity.ok().build();
   }

}
