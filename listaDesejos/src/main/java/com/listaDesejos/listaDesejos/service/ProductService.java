package com.listaDesejos.listaDesejos.service;

import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //criar produto no banco
    public Product criarProduto(Product product) {
        return productRepository.save(product);
    }

    //exibir produto
    public Optional<Product> exibirProduto(String name) {
        return productRepository.findByname(name);
    }

    public Optional<Product> findProductById(long id){
        return productRepository.findByID(id);
    }
}
