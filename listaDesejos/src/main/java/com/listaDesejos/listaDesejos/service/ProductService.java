package com.listaDesejos.listaDesejos.service;

import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //metodo que cadastra um produto no banco
    public Product registerProduct(Product product) {
        return productRepository.save(product);
    }

    //metodo que retorna todos os produtos do banco
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //metodo que retorna um produto específico do banco (busca por id)
    public Optional<Product> searchProduct(long id) {
        return productRepository.findByID(id);
    }

    //metodo que retorna um produto específico do banco (busca por nome)
    public Product searchProductByName(String name) {
        return productRepository.findByName(name);
    }
}
