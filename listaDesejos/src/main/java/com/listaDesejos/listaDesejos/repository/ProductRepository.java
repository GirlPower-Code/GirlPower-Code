package com.listaDesejos.listaDesejos.repository;

import com.listaDesejos.listaDesejos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    //registrar produto
    Product save(Product product);

    //exibir produto
    Optional<Product> findByname(String name);
}
