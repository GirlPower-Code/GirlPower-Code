package com.listaDesejos.listaDesejos.controller;

import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired //injeta uma instancia automaticamente aqui na variavel
    private ProductService productService;

    //metodo que cadastra um produto no banco
    @PostMapping("/products/create")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) { //o parametro product está anotado como requestbody = corpo da requisição que é JSON vai ser convertido pra objeto Java do tipo Product

        try{
            Optional<Product> productSave = Optional.ofNullable(productService.registerProduct(product));

                System.out.println("Produto " + productSave.get().getName() + " cadastrado com sucesso!");
                return new ResponseEntity<>((Product) productService.registerProduct(product), HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //metodo que retorna todos os produtos do banco
    @GetMapping("/products")
    public ResponseEntity<?> listAllProducts() {

        try{
            List<Product> allProducts = productService.getAllProducts();

            if (allProducts.isEmpty() ) {
                System.out.println("Nenhum produto cadastrado.");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //metodo que rotorna um produto específico do banco
    @GetMapping("/products/{id}")
    public ResponseEntity<?> oneProduct(@PathVariable long id) {

        try{
            Optional<Product> idProduct = productService.searchProduct(id);

            if (idProduct.isEmpty()) {
                System.out.println("Esse produto não existe.");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productService.searchProduct(id), HttpStatus.FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
