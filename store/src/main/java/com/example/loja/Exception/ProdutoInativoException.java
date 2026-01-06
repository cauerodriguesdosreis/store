package com.example.loja.Exception;

public class ProdutoInativoException extends RuntimeException {

    public ProdutoInativoException() {
        super("Produto inativo.");
    }
}
