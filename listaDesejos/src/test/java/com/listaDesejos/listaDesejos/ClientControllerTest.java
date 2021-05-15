package com.listaDesejos.listaDesejos;

import com.listaDesejos.listaDesejos.entity.Client;
import com.listaDesejos.listaDesejos.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class ClientControllerTest {
    @Autowired
    ClientService clientService;

    @Test
    void registerClient(){
        //given
        Client client = new Client();
        client.setName("Jane Doe");
        client.setCpf("25125125102");
        client.setBirthday("15/02/1695");
        client.setEmail("janedoe@janedoe.com");
        client.setNumber("363363125012");
        client.setPassword("password");

        //when
        Client registeredClient = clientService.registerClient(client);

        //then
        assertThat(registeredClient).isNotNull();

    }

    @Test
    public void getUserByEmail() {
        // given
        Client client = new Client();
        clientService.registerClient(client);

        // when
        Client searchClient = clientService.registeredClient(client.getEmail());

        // then
        assertThat(searchClient.getName()).isEqualTo(client.getName());
    }
}

