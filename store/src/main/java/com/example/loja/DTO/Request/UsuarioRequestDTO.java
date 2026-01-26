package com.example.loja.DTO.Request;

import com.example.loja.Entity.UsuarioEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDTO {

    @NotBlank (message = "Este campo não deve estar vazio.")
    private String nome;

    @NotBlank (message = "Este campo não deve estar vazio.")
    private String email;

    @NotBlank (message = "Este campo não deve estar vazio.")
    @Size (min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
    private String senha;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
