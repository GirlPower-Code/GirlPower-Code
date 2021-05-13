package com.listaDesejos.listaDesejos.repository;

import com.listaDesejos.listaDesejos.entity.Client;
import com.listaDesejos.listaDesejos.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<WishList, Long> {

    WishList save(WishList wishList);

    WishList findByID(long id);
    // WishList findAllByClient(Client client);

}
