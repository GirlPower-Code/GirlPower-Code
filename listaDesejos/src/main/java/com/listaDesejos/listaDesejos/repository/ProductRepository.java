package com.listaDesejos.listaDesejos.repository;

import com.listaDesejos.listaDesejos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    //cadastrar um produto no banco
    Product save(Product product);

    //retorna todos os produtos do banco
    List<Product> findAll();

    //buscar produto no banco
    Product findByID(long id);

    //excluir produto no banco
    void deleteByID(long id);
}
