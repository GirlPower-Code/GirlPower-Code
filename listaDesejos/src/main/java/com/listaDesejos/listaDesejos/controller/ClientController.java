package com.listaDesejos.listaDesejos.controller;

import com.listaDesejos.listaDesejos.entity.Client;
import com.listaDesejos.listaDesejos.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @ApiOperation(value = "Cadastrar novo cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente cadastrado com sucesso", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request!", response = Response.class)
    })
    @PostMapping("/client/register")
    public ResponseEntity<Client> registerClient(@RequestBody Client client){
        try{

            Optional<Client> searchClient = Optional.ofNullable(clientService.registeredClient(client.getEmail()));

            if (searchClient.isPresent()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(clientService.registerClient(client), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Procurar cliente por email")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente retornado com sucesso", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request!", response = Response.class)
    })
    @GetMapping("/client/find/{email}")
    public ResponseEntity<Client> registeredClient(@PathVariable(value = "email") String email) {
        try{
            return new ResponseEntity<>((Client) clientService.registeredClient(email), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
