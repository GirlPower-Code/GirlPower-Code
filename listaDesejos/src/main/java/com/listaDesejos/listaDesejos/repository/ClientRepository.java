package com.listaDesejos.listaDesejos.repository;

import com.listaDesejos.listaDesejos.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client save(Client client);

    Client findByEmail(String email);

    Optional<Client> findByID(long id);
}

