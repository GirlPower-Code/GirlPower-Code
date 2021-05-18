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

    @PostMapping("/createwishlist")
    public ResponseEntity<WishList> createWishlist(@RequestBody WishList wishList){
        try {
            return new ResponseEntity<>(wishListService.createWishList(wishList), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add/{id_client}/{id_prod}")
    public WishList addProduct(@PathVariable long id_prod, @PathVariable long id_client){

        Optional<Client> searchClient = clientService.getClientById(id_client);
        Optional<Product> searchProduct = productService.findProductById(id_prod);

        if(searchClient.isPresent() && searchProduct.isPresent()) {
            Long id_wishlist = wishListService.getWishlist(searchClient.get()).getID();

            return wishListService.addWishToWishlist(id_wishlist, searchProduct.get());
        }

        return null;
    }

    @DeleteMapping("/delete/{id_client}/{id_prod}")
    public WishList deleteProduct(@PathVariable long id_client, @PathVariable long id_prod){

        Optional<Client> searchClient = clientService.getClientById(id_client);
        Optional<Product> searchProduct = productService.findProductById(id_prod);

        if(searchClient.isPresent() && searchProduct.isPresent()) {
            Long id_wishlist = wishListService.getWishlist(searchClient.get()).getID();

            return wishListService.deleteWishToWishlist(id_wishlist, searchProduct.get());
        }

        return null;
    }

    @GetMapping("/list/{id}")
    public List<Product> listProducts(@PathVariable long id){
        Optional<Client> searchClient = clientService.getClientById(id);

        if(searchClient.isPresent()) {
            List<Product> wishlist = wishListService.getWishlist(searchClient.get()).getProduct();

            return wishlist;
        }

        return null;
    }

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
