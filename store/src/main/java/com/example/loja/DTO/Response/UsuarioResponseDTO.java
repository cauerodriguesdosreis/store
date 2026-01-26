package com.example.loja.DTO.Response;

import com.example.loja.DTO.Request.UsuarioRequestDTO;
import com.example.loja.Entity.UsuarioEntity;
import jakarta.validation.Valid;

public class UsuarioResponseDTO {

    private String nome;

    private String email;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public UsuarioResponseDTO(UsuarioEntity usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
