package com.listaDesejos.listaDesejos;

import com.listaDesejos.listaDesejos.entity.Client;
import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.entity.WishList;
import com.listaDesejos.listaDesejos.service.WishListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class WishListControllerTest {

    @Autowired
    WishListService wishListServiceTeste;



    @Test
    void criarWishListdoCliente(){

        //Eu preciso disso
        List<Product> prod = new ArrayList<>();
        WishList wishList = new WishList();
        Client clienteCarol = new Client();

        clienteCarol.setCpf("14628");
        clienteCarol.setName("Carol");
        clienteCarol.setBirthday("14/07/2001");
        clienteCarol.setNumber("91952328");
        clienteCarol.setEmail("ribeiro@gmail.com");
        clienteCarol.setPassword("123456");

        Product product = new Product();
        product.setName("Geladeira");
        BigDecimal valor = new BigDecimal(10);
        product.setPrice(valor);
        product.setDescripcion("a");


        prod.add(product);


         wishList.setClient(clienteCarol);
         wishList.setProduct(prod);


        //Quando
         wishListServiceTeste.createWishList(wishList);

        //Resultado
         assertThat(wishList.getProduct().contains(product)).isTrue();



    }

    @Test
    void deletarProdutodaWishList(){


        List<Product> prod = new ArrayList<>();
        WishList wishList = new WishList();
        Client clienteRaissa = new Client();

        clienteRaissa.setCpf("11251131646131");
        clienteRaissa.setName("Raissa");
        clienteRaissa.setBirthday("12/07/2003");
        clienteRaissa.setNumber("919516128");
        clienteRaissa.setEmail("raissao@gmail.com");
        clienteRaissa.setPassword("1556");

        Product product = new Product();
        product.setName("Celular");
        BigDecimal valor = new BigDecimal(1800);
        product.setPrice(valor);
        product.setDescripcion("Motorola");

        Product product1 = new Product();
        product.setName("Computador");
        BigDecimal v = new BigDecimal(50000);
        product.setPrice(v);
        product.setDescripcion("Acer");

        prod.add(product);
        prod.add(product1);

        wishList.setClient(clienteRaissa);
        wishList.setProduct(prod);


        wishList.getProduct().remove(product);

        WishList wishList1= wishListServiceTeste.createWishList(wishList);


        assertThat(wishList1.getProduct().contains(product)).isFalse();

    }

    @Test
    void addProdutodaWishList(){


        List<Product> prod = new ArrayList<>();
        WishList wishList = new WishList();
        Client clienteRaissa = new Client();

        clienteRaissa.setCpf("11251131646131");
        clienteRaissa.setName("Raissa");
        clienteRaissa.setBirthday("12/07/2003");
        clienteRaissa.setNumber("919516128");
        clienteRaissa.setEmail("raissao@gmail.com");
        clienteRaissa.setPassword("1556");

        Product product = new Product();
        product.setName("Celular");
        BigDecimal valor = new BigDecimal(1800);
        product.setPrice(valor);
        product.setDescripcion("Motorola");

        Product product1 = new Product();
        product.setName("Computador");
        BigDecimal v = new BigDecimal(50000);
        product.setPrice(v);
        product.setDescripcion("Acer");

        prod.add(product);


        wishList.setClient(clienteRaissa);
        wishList.setProduct(prod);


        wishList.getProduct().add(product1);

        WishList wishList1= wishListServiceTeste.createWishList(wishList);


        assertThat(wishList1.getProduct().contains(product1)).isTrue();

    }


    @Test
    void pegarWishList(){


        List<Product> prod = new ArrayList<>();
        WishList wishList = new WishList();
        Client clienteRaissa = new Client();

        clienteRaissa.setCpf("11251131646131");
        clienteRaissa.setName("Raissa");
        clienteRaissa.setBirthday("12/07/2003");
        clienteRaissa.setNumber("919516128");
        clienteRaissa.setEmail("raissao@gmail.com");
        clienteRaissa.setPassword("1556");

        Product product = new Product();
        product.setName("Celular");
        BigDecimal valor = new BigDecimal(1800);
        product.setPrice(valor);
        product.setDescripcion("Motorola");

        Product product1 = new Product();
        product.setName("Computador");
        BigDecimal v = new BigDecimal(50000);
        product.setPrice(v);
        product.setDescripcion("Acer");

        prod.add(product);
        prod.add(product1);


        wishList.setClient(clienteRaissa);
        wishList.setProduct(prod);

        wishListServiceTeste.createWishList(wishList);

        //WishList wishList1= wishListServiceTeste.getWishlist(wishList.getClient());
        WishList wishList1= wishListServiceTeste.findByID(wishList.getID());

        assertThat(wishList1.getProduct().size()).isEqualTo(wishList);

    }












}
