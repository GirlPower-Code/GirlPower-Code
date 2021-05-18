package com.listaDesejos.listaDesejos.repository;

import com.listaDesejos.listaDesejos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    //cadastrar um produto no banco
    Product save(Product product);

    //retorna todos os produtos do banco
    List<Product> findAll();

    //buscar produto no banco
    Optional<Product> findByID(long id);

    //buscar produto no banco por nome
    Optional<Product> findByName(String name);
}
