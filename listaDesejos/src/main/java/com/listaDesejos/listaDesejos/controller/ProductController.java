package com.listaDesejos.listaDesejos.controller;

import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired //injeta uma instancia automaticamente aqui na variavel
    private ProductService productService;

    //metodo que cadastra um produto no banco
    @PostMapping("/products/create")
    @ResponseStatus(HttpStatus.CREATED) //protocolo correto pra create cod 201
    public Product addProduct(@RequestBody Product product) { //o parametro product está anotado como requestbody = corpo da requisição que é JSON vai ser convertido pra objeto Java do tipo Product
        return productService.registerProduct(product); //retorna o product que foi salvo lá no service
    }

    //metodo que retorna todos os produtos do banco
    @GetMapping("/products") //vai mapear o endpoint pra receber requisições iniciado com products
    public List<Product> listAllProducts() { //importada a classe Product lá do model entity
        return productService.getAllProducts();
    }

    //metodo que rotorna um produto específico do banco
    @GetMapping("/products/{id}")
    public Product oneProduct(@PathVariable long id) {
        return productService.searchProduct(id);
    }

    //metodo que exclui um produto específico do banco
    @DeleteMapping("/products/{id}")
    public void delProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }

}
