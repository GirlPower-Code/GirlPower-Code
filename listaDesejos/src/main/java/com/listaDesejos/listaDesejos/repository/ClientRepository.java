package com.listaDesejos.listaDesejos.repository;

import com.listaDesejos.listaDesejos.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client save(Client client);

    Optional<Client> findByID(Long id);

    Optional<Client> findByemail(String email);

}

