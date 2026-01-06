package com.example.loja.DTO.Request;

import com.example.loja.Entity.ProdutoEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.List;
import java.util.stream.Collector;

public class ProdutoRequestDTO {

    @NotBlank (message = "Este campo não deve estar vazio.")
    private String nome;

    @NotBlank (message = "Este campo não deve estar vazio.")
    private String descricao;

    @Positive (message = "Este campo deve ser positivo.")
    private double preco;

    @Positive (message = "Este campo deve ser positivo.")
    private Integer qtdEstoque;

    public ProdutoRequestDTO() {
    }

    public ProdutoRequestDTO(String nome, String descricao, double preco, Integer qtdEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
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
