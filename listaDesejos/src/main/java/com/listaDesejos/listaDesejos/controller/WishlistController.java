package com.listaDesejos.listaDesejos.controller;

import com.listaDesejos.listaDesejos.entity.Client;
import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.entity.WishList;
import com.listaDesejos.listaDesejos.service.ClientService;
import com.listaDesejos.listaDesejos.service.ProductService;
import com.listaDesejos.listaDesejos.service.WishListService;
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
public class WishlistController {

    @Autowired
    WishListService wishListService;

    @Autowired
    ClientService clientService;

    @Autowired
    ProductService productService;


    //CRIAR WISHLIST
    @ApiOperation(value = "Criar a Wishlist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Wishlist criada com sucesso", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request!", response = Response.class)
    })
    @PostMapping("/wishlist")
    public WishList createWishlist(@RequestBody WishList wishList){
        return wishListService.createWishList(wishList);
    }


    //LISTAR TODOS OS PRODUTOS
    @ApiOperation(value = "Listar produtos da Wishlist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produtos da Wishlist retornados com sucesso", response = Response.class),
            @ApiResponse(code = 204, message = "Nenhum produto adicionado na Wishlist", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request!", response = Response.class)
    })
    @GetMapping("/wishlist/{id}")
    public ResponseEntity<?> allProductsWishlist(@PathVariable long id) {
        log.info("Produtos da wishlist");
        try{
            Optional<Client> searchClient = clientService.getClientById(id);

            if (searchClient.isPresent()) {
                List<Product> products = wishListService.getWishlist(searchClient.get()).getProduct();
                log.info("Produto encontrado e retornado");
                return new ResponseEntity<>(products, HttpStatus.OK);
            }
            log.info("Nenhum produto adicionado");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (Exception e) {
            log.error("Falha ao fazer requisicao de listar produtos da Wishlist");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    //ADICIONAR UM PRODUTO
    @ApiOperation(value = "Adicionar um produto na Wishlist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto adicionado com sucesso", response = Response.class),
            @ApiResponse(code = 409, message = "Esse peoduto já foi adicionado em sua lista de desejos", response = Response.class),
            @ApiResponse(code = 502, message = "Bad gateway!", response = Response.class)
    })
    @PutMapping("/wishlist/adicionar/{id_client}/{id_prod}")
    public ResponseEntity<WishList> adicionarProduct(@PathVariable long id_client, @PathVariable long id_prod) {
        try {
            Optional<Client> searchClient = clientService.getClientById(id_client);
            Optional<Product> searchProduct = productService.findProductById(id_prod);


            if( searchClient.isPresent() && searchClient.isPresent()){
                Long id_wishlist = wishListService.getWishlist(searchClient.get()).getID();
                WishList wishList= wishListService.findByID(id_wishlist);

                List<Product> listadeProd = wishList.getProduct();

                if(listadeProd.size()==20){
                    return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
                }else {
                    for(Product product: listadeProd) {
                        if (product.getID().equals(id_prod)) {
                            return new ResponseEntity<>(HttpStatus.CONFLICT);
                        } else {
                            listadeProd.add(searchProduct.get());
                            wishList.setProduct(listadeProd);
                            WishList wishListNova = wishListService.createWishList(wishList);
                            return new ResponseEntity<>(HttpStatus.OK);
                        }
                    }
                }
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    //DELETAR UM PRODUTO
    @ApiOperation(value = "Remover um produto da Wishlist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto removido com sucesso", response = Response.class),
            @ApiResponse(code = 404, message = "Não é possivel remover, produto não existe em sua lista de desejos", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request!", response = Response.class)
    })
    @PutMapping("/wishlist/delete/{id_client}/{id_prod}")
    public ResponseEntity<WishList> deleteProduct(@PathVariable long id_client, @PathVariable long id_prod) {
        try {
            Optional<Client> searchClient = clientService.getClientById(id_client);
            Optional<Product> searchProduct = productService.findProductById(id_prod);


            if( searchProduct.isPresent() && searchClient.isPresent()){
                Long id_wishlist = wishListService.getWishlist(searchClient.get()).getID();
                WishList wishList= wishListService.findByID(id_wishlist);

                List<Product> listadeProd = wishList.getProduct();


                for(Product product: listadeProd) {
                    if (product.getID().equals(id_prod)) {
                        listadeProd.remove(product);
                        wishList.setProduct(listadeProd);
                        WishList wishListNova= wishListService.createWishList(wishList);
                        return new ResponseEntity<>(wishListNova,HttpStatus.OK);
                    }
                }
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    // PESQUISAR UM PRODUTO PELO NOME
    @ApiOperation(value = "Buscar produto na Wishlist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto encontrado", response = Response.class),
            @ApiResponse(code = 404, message = "Esse produto ainda não está em sua lista de desejos", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request!", response = Response.class)
    })
    @GetMapping("/find/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable long id, @RequestParam(value = "name") String name){

        log.info("Acessando rota de buscar produto pelo nome");

        try {
            Optional<Product> searchProduct = productService.showProduct(name);
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