package com.example.loja.Repository;

import com.example.loja.Entity.ProdutoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository <ProdutoEntity, Long> {

    Optional <ProdutoEntity> findByNomeAndAtivoTrue(String nome);

    Optional <ProdutoEntity> findByNome(String nome);

    List <ProdutoEntity> findByNomeContainingAndAtivoTrue(String nome);
}
