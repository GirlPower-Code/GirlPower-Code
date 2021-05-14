package com.listaDesejos.listaDesejos.controller;

import ch.qos.logback.classic.Logger;
import com.listaDesejos.listaDesejos.entity.Client;
import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.entity.WishList;
import com.listaDesejos.listaDesejos.service.ClientService;
import com.listaDesejos.listaDesejos.service.ProductService;
import com.listaDesejos.listaDesejos.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    WishListService wishListService;
    @Autowired
    ProductService productService;

    @Autowired
    ClientService clientService;


    @DeleteMapping("/delete/{id_cliente}/{id_produto}")
        public ResponseEntity<Product> deletarProduto(@PathVariable long id_produto,@PathVariable long id_cliente) {


        Optional<Product> searchProduct = productService.buscarProduto(id_produto);
        Optional<Client> searchClient = clientService.getClientById(id_cliente);

        if (searchProduct.isPresent() && searchClient.isPresent()) {
            WishList wishlist = wishListService.getWishlist(searchClient.get());
            List<Product> products = new ArrayList<Product>();

                for (Product product : products) {
                        if (product.getID().equals(id_produto)) {
                            products.remove(product);

                        }


            }
        }
        return null;
    }






}
