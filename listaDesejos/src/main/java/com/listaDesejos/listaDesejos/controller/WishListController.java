package com.listaDesejos.listaDesejos.controller;

import com.listaDesejos.listaDesejos.entity.Client;
import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.entity.WishList;
import com.listaDesejos.listaDesejos.service.ClientService;
import com.listaDesejos.listaDesejos.service.ProductService;
import com.listaDesejos.listaDesejos.service.WishListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    WishListService wishListService;

    @Autowired
    ProductService productService;

    @Autowired
    ClientService clientService;

    // Pesquisar produto na wishlist
    @GetMapping("/find/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable long id, @RequestParam(value = "name") String name){

        log.info("Acessando rota de buscar produto pelo nome");

        try {
            Optional<Product> searchProduct = productService.exibirProduto(name);
            Optional<Client> searchClient = clientService.getClientById(id);

            if( searchProduct.isPresent() && searchClient.isPresent()){
                WishList wishlist = wishListService.getWishlist(searchClient.get());
                List<Product> products = wishlist.getProduct();

                if(wishlist.getProduct().contains(searchProduct.get())){
                    Product productFound = new Product();

                    for (Product product : products) {
                        if(product.getName().equals(name)){
                            productFound = product;

                            log.info("Produto encontrado e retornado");

                            return new ResponseEntity<>(product, HttpStatus.OK);
                        }
                    }
                }
            }

            log.info("Produto nao foi encontrado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            log.error("Falha ao fazer requisicao de buscar por produto");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
