package com.listaDesejos.listaDesejos.controller;

import com.listaDesejos.listaDesejos.entity.WishList;
import com.listaDesejos.listaDesejos.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    WishListService wishListService;


}
