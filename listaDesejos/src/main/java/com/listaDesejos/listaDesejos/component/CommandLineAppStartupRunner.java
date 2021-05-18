package com.listaDesejos.listaDesejos.component;

import com.listaDesejos.listaDesejos.entity.Client;
import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.entity.WishList;
import com.listaDesejos.listaDesejos.service.ClientService;
import com.listaDesejos.listaDesejos.service.ProductService;
import com.listaDesejos.listaDesejos.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Autowired
    private WishListService wishListService;

    @Override
    public void run(String... args){
        this.createOrder();
    }

    private void createOrder() {
        List<Product> products = new ArrayList<Product>();
        WishList wishList = new WishList();
        Client clienteCarol = new Client();

        clienteCarol.setCpf("12312312312");
        clienteCarol.setName("Carol");
        clienteCarol.setBirthday("14/07/2001");
        clienteCarol.setNumber("91952328");
        clienteCarol.setEmail("carol@gmail.com");
        clienteCarol.setPassword("123456");
        clientService.registerClient(clienteCarol);

        Client clienteRaissa = new Client();

        clienteRaissa.setCpf("12312312312");
        clienteRaissa.setName("raissa");
        clienteRaissa.setBirthday("14/07/2001");
        clienteRaissa.setNumber("91952328");
        clienteRaissa.setEmail("raissa@gmail.com");
        clienteRaissa.setPassword("123456");
        clientService.registerClient(clienteRaissa);

        Product product = new Product();
        product.setName("Geladeira");
        BigDecimal valor = new BigDecimal(10);
        product.setPrice(valor);
        product.setDescripcion("a");
        Product create = productService.criarProduto(product);

        Product product1 = new Product();
        product1.setName("Fogao");
        BigDecimal valor1 = new BigDecimal(10);
        product1.setPrice(valor1);
        product1.setDescripcion("a");
        Product create1 = productService.criarProduto(product1);

        Product product3 = new Product();
        product3.setName("Panela");
        BigDecimal valor2 = new BigDecimal(10);
        product3.setPrice(valor2);
        product3.setDescripcion("a");
        productService.criarProduto(product3);

        products.add(create);
        products.add(create1);

        wishList.setClient(clienteCarol);
        wishList.setProduct(products);

        wishListService.adicionarWishList(wishList);

    }
}
