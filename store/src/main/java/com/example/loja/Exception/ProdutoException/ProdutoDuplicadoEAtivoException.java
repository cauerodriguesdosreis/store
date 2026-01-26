package com.example.loja.Exception.ProdutoException;

public class ProdutoDuplicadoEAtivoException extends RuntimeException {

    public ProdutoDuplicadoEAtivoException() {

      super("Produto já em uso. Use outro nome.");
    }
}
