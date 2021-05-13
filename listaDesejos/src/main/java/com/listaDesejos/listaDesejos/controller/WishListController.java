package com.listaDesejos.listaDesejos.controller;

import com.listaDesejos.listaDesejos.entity.Client;
import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.entity.WishList;
import com.listaDesejos.listaDesejos.service.ClientService;
import com.listaDesejos.listaDesejos.service.ProductService;
import com.listaDesejos.listaDesejos.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // Pesquisar produto na wishlist
    @GetMapping("/search/{id}/{name}")
    public Boolean findProduct(@PathVariable long id, @PathVariable String name){
        Optional<Product> searchProduct = productService.exibirProduto(name);
        Optional<Client> searchClient = clientService.getClientById(id);

        if( searchProduct.isPresent() && searchClient.isPresent()){
            WishList wishlist = wishListService.getProductFromWishlist(searchClient.get());

            return wishlist.getProduct().contains(searchProduct.get());
        }

        return null;
    }
}
