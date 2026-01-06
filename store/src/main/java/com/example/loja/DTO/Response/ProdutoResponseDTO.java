package com.example.loja.DTO.Response;

import com.example.loja.Entity.ProdutoEntity;

import java.util.Optional;

public class ProdutoResponseDTO {

    private String nome;

    private String descricao;

    private double preco;

    private Integer qtdEstoque;

    public ProdutoResponseDTO() {
    }

    public ProdutoResponseDTO (String nome, String descricao, double preco, Integer qtdEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public ProdutoResponseDTO(ProdutoEntity produto) {
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.qtdEstoque = produto.getQtdEstoque();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }


}
