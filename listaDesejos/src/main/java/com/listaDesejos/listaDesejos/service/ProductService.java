package com.listaDesejos.listaDesejos.service;

import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //criar produto no banco
    public Product criarProduto(Product product) {
        return productRepository.save(product);
    }

    //exibir produto
    public Product exibirProduto(long id) {
        return productRepository.findById(id);
    }

    //deletar produto
    public Product deletarProduto(long id) {
        return productRepository.delete(id);
    }

}
