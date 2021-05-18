package com.listaDesejos.listaDesejos.controller;

import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired //injeta uma instancia automaticamente aqui na variavel
    private ProductService productService;

    @ApiOperation(value = "Cadastrar um novo produto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Produto cadastrado e retornado", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request!", response = Response.class)
    })
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


    @ApiOperation(value = "Retornar todos os produtos")
    @ApiResponses(value = {
             @ApiResponse(code = 200, message = "Produtos retornados com sucesso", response = Response.class),
            @ApiResponse(code = 204, message = "Nenhum produto cadastrado", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request!", response = Response.class)
    })
    @GetMapping("/products")
    public ResponseEntity<?> listAllProducts() {

        try{
            List<Product> allProducts = productService.getAllProducts();

            if (allProducts.isEmpty()) {
                System.out.println("Nenhum produto cadastrado.");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @ApiOperation(value = "Retornar um determinado produto")
    @ApiResponses(value = {
            @ApiResponse(code = 302, message = "Produto encontrado", response = Response.class),
            @ApiResponse(code = 404, message = "Esse produto não está cadastrado", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request!", response = Response.class)
    })
    @GetMapping("/products/{id}")
    public ResponseEntity<?> oneProduct(@PathVariable long id) {

        try{
            Optional<Product> idProduct = productService.findProductById(id);

            if (idProduct.isEmpty()) {
                System.out.println("Esse produto não existe.");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
