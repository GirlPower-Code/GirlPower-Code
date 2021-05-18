package com.listaDesejos.listaDesejos.entity.DTO;

import com.listaDesejos.listaDesejos.entity.Client;
import com.sun.istack.NotNull;

import javax.persistence.Column;

public class ClientDTO {


    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String birthday;

    @Column
    @NotNull
    private String number;

    @Column
    @NotNull
    private String email;


    public ClientDTO(Client client){
        this.name = client.getName();
        this.birthday = client.getBirthday();
        this.email = client.getEmail();
        this.number = client.getNumber();
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public static ClientDTO converter(Client client){
        return new ClientDTO(client);
    }

}
