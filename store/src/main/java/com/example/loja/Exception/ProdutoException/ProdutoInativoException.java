package com.example.loja.Exception.ProdutoException;

public class ProdutoInativoException extends RuntimeException {

    public ProdutoInativoException() {
        super("Produto inativo.");
    }
}
