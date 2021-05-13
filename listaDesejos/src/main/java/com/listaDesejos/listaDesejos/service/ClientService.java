package com.listaDesejos.listaDesejos.service;

import com.listaDesejos.listaDesejos.entity.Client;
import com.listaDesejos.listaDesejos.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Registar um novo cliente
    public Client registerClient(Client client){
        return clientRepository.save(client);
    }

    public Optional<Client> getClient(String email) {
        return clientRepository.findByemail(email);
    }
}
