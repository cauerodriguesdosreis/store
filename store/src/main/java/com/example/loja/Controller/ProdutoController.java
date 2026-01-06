package com.example.loja.Controller;


import com.example.loja.DTO.Request.ProdutoRequestDTO;
import com.example.loja.DTO.Response.ProdutoResponseDTO;
import com.example.loja.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping ("/listar")
    ResponseEntity<List<ProdutoResponseDTO>> listarProdutos(){
    return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ProdutoResponseDTO> listarProdutoPorId(@PathVariable Long id){

        return ResponseEntity.ok(produtoService.listarProdutoPorId(id));
    }

    @GetMapping("/buscar/{nome}")
    public ResponseEntity<ProdutoResponseDTO> buscarProdutoPorStatusAtivo(@PathVariable String nome){

        return ResponseEntity.ok(produtoService.buscarProdutoPorStatusAtivo(nome));
    }

    @GetMapping("/buscar/parcial/{nome}")
    public ResponseEntity<List> buscarProdutoPorNomeParcial(@PathVariable String nome){
        return ResponseEntity.ok(produtoService.buscarProdutoPorNomeParcial(nome));
    }

    @PostMapping("/criar")
    public ResponseEntity<ProdutoRequestDTO> criarProduto(@Valid @RequestBody ProdutoRequestDTO dto){
        produtoService.criarProduto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<?> atualizarProduto(@Valid @PathVariable Long id, @RequestBody ProdutoRequestDTO dto){
        return ResponseEntity.ok(produtoService.atualizarProduto(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso!");

    }

    @PatchMapping("/desativar/{id}")
    public ResponseEntity<?> desativarProduto(@PathVariable Long id) {
        produtoService.desativarProduto(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto desativado com sucesso!");
    }

}
