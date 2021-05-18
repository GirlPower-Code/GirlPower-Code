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
@RequestMapping("wishlist")
public class WishlistController {

    @Autowired
    WishListService wishListService;

    @Autowired
    ClientService clientService;

    @Autowired
    ProductService productService;





    //Retornar todos os produtos da wishlist
    @GetMapping("/{id}")
    public ResponseEntity<?> allProductsWishlist(@PathVariable long id) {

        log.info("Produtos da wishlist");

        try{
            Optional<Client> searchClient = clientService.registeredClientId(id);
            Optional<Product> searchProduct = productService.searchProduct(id);

            if (searchClient.isPresent() && searchProduct.isPresent()) {
                WishList wishlist = wishListService.getWishlist(searchClient.get());
                List<Product> products = wishlist.getProduct();

                return new ResponseEntity<>(products, HttpStatus.OK);
            }
        }catch (Exception e) {
            log.info("Wishlist vazia");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return null;
    }
}
