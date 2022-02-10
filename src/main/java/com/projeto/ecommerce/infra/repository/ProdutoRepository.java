package com.projeto.ecommerce.infra.repository;

import com.projeto.ecommerce.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
    public List<Produto> buscar(@Param("nome") String nome);
}
