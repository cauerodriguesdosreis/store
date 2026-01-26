package com.example.loja.Repository;

import com.example.loja.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Long> {

    UsuarioEntity findByEmail(String email);

    List<UsuarioEntity> findByNomeContaining(String nome);
}
