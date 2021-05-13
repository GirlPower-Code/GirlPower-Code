package com.listaDesejos.listaDesejos.controller;

import com.listaDesejos.listaDesejos.entity.Client;
import com.listaDesejos.listaDesejos.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("/register")
    public Client registerClient(@RequestBody Client client){
        Optional<Client> searchClient = clientService.getClient(client.getEmail());

        if (searchClient.isPresent()){
            return null;
        }

        return clientService.registerClient(client);
    }
}
