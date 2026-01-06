package com.example.loja.Exception;

public class ProdutoDuplicadoEAtivoException extends RuntimeException {

    public ProdutoDuplicadoEAtivoException() {

      super("Produto já em uso. Use outro nome.");
    }
}
