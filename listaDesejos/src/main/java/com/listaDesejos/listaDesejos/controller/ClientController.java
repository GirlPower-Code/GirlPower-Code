package com.listaDesejos.listaDesejos.controller;

import com.listaDesejos.listaDesejos.entity.Client;
import com.listaDesejos.listaDesejos.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<Client> registerClient(@RequestBody Client client){
        try{
            return new ResponseEntity<>((Client) clientService.registerClient(client), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<Client> registeredClient(@PathVariable(value = "email") String email) {
        try{
            return new ResponseEntity<>((Client) clientService.registeredClient(email), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
