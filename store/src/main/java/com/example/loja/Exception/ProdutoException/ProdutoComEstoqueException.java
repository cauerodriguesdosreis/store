package com.example.loja.Exception.ProdutoException;

public class ProdutoComEstoqueException extends RuntimeException {
    public ProdutoComEstoqueException() {
        super("Produto possui estoque. Não é possível removê-lo.");
    }
}
