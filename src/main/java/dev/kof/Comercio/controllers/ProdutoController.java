package dev.kof.Comercio.controllers;

import dev.kof.Comercio.GlobalHandlingException.ResourceNotFoundException;
import dev.kof.Comercio.domain.produto.Produto;
import dev.kof.Comercio.domain.produto.ProdutoRepository;
import dev.kof.Comercio.domain.produto.RequestProduto;
import dev.kof.Comercio.domain.produto.UpdateProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/bazinga")
public class ProdutoController {
   @Autowired
   private ProdutoRepository repository;

   @GetMapping
   public ResponseEntity<?> getProdutos() {
       var allProdutos = repository.findAll();
       return ResponseEntity.ok(allProdutos);
   }

   @GetMapping("/{codProd}")
   public ResponseEntity<?> findProduto(@PathVariable Integer codProd) {
           var produto = repository.findById(codProd)
                .orElseThrow(() -> new ResourceNotFoundException("'Produto com código:'" + codProd + "' não foi encontrado"));

           return ResponseEntity.ok(produto);
   }
   @GetMapping("/desc")
   public ResponseEntity<?> findDescricao (@RequestParam String descricao) {
       var produto = repository.findByDescricao(descricao)
            .orElseThrow(() -> new ResourceNotFoundException("'Produto com descrição:'" + descricao + "' não foi encontrado"));

       return ResponseEntity.ok(produto);
   }

   @PostMapping
   public ResponseEntity<?> registerProduto(@RequestBody @Valid RequestProduto data) {
        Produto novoProduto = new Produto(data);
        repository.save(novoProduto);
        return new ResponseEntity<>("Criado com sucesso!", HttpStatus.CREATED);
   }

   @PutMapping("/{codProd}")
    public ResponseEntity<?> updateProduto(@PathVariable Integer codProd, @RequestBody @Valid UpdateProduto data) {
        Optional<Produto> optionalProduto = repository.findById(codProd);
        if(optionalProduto.isPresent()) {

           Produto produto = optionalProduto.get();
           if(data.descricao() != null) {
               produto.setDescricao(data.descricao());
           }

           if(data.qtd() >= 0) {
               produto.setQtd(data.qtd());
           }

           if(data.precoCompra() != 0) {
               produto.setPrecoCompra(data.precoCompra());
           }

           if(data.precoVenda() != 0) {
               produto.setPrecoVenda(data.precoVenda());
           }

           if(data.codBarra() != null) {
               produto.setCodBarra(data.codBarra());
           }

           if(data.ncm() != null) {
               produto.setNcm(data.ncm());
           }

           repository.save(produto);

           return ResponseEntity.ok(optionalProduto);
        }else{
           return new ResponseEntity<>("Não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codProd}")
    public ResponseEntity<?> deleteProduto(@PathVariable Integer codProd){
       var produto = repository.findById(codProd)
               .orElseThrow(() -> new ResourceNotFoundException("'Produto com código:'" + codProd + "' não foi encontrado"));

            repository.deleteById(codProd);
            return new ResponseEntity<>("Deletado com sucesso.", HttpStatus.OK);

    }
}
