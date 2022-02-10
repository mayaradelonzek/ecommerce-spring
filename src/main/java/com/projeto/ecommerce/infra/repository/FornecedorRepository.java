package com.projeto.ecommerce.infra.repository;

import com.projeto.ecommerce.domain.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    @Query("SELECT f FROM Fornecedor f WHERE f.nomeFantasia LIKE %:nome%")
    public List<Fornecedor> buscar(@Param("nome") String nomeFantasia);

}
