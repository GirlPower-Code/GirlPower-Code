package com.listaDesejos.listaDesejos.repository;

import com.listaDesejos.listaDesejos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    //registrar produto
    Product save(Product product);

    //exibir produto
    Product findById(long ID);

    //deletar produto
    Product delete(long ID);

}
