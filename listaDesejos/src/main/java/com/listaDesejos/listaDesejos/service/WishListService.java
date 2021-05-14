package com.listaDesejos.listaDesejos.service;

import com.listaDesejos.listaDesejos.entity.Client;
import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.entity.WishList;
import com.listaDesejos.listaDesejos.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishListService {

    @Autowired
    private WishlistRepository wishlistRepository;


    //add wishlis no banco de dados
    public WishList adicionarWishList(WishList wishList){
        return wishlistRepository.save(wishList);
    }

    //mostrar a lista de desejos do cliente
    public WishList mostrarWishList(long id){
        return wishlistRepository.findByID(id);
    }


    public WishList deletarProduto(long id){ return wishlistRepository.deleteByID(id);
    }

    public WishList getWishlist(Client client){
        return wishlistRepository.findByclient(client);
    }








}
