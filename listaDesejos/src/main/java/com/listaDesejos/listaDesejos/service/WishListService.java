package com.listaDesejos.listaDesejos.service;

import com.listaDesejos.listaDesejos.entity.Client;
import com.listaDesejos.listaDesejos.entity.Product;
import com.listaDesejos.listaDesejos.entity.WishList;
import com.listaDesejos.listaDesejos.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public WishList getWishlist(Client client){
        return wishlistRepository.findByclient(client);
    }



    public WishList createWishList(WishList wishList){
        return wishlistRepository.save(wishList);
    }


    public WishList deletarProduto(long id){ return wishlistRepository.deleteByID(id);
    }


    public WishList addWishToWishlist(long id_wishlist, Product product){
        WishList wishList = wishlistRepository.findByID(id_wishlist);
        wishList.getProduct().add(product);
        return wishlistRepository.save(wishList);
    }


    public WishList deleteWishToWishlist(long id, Product product){
        WishList wishList = wishlistRepository.findByID(id);
        wishList.getProduct().remove(product);

        return wishlistRepository.save(wishList);
    }

    public WishList findByID(Long id_wishlist) {
        return wishlistRepository.findByID(id_wishlist);
    }
}
