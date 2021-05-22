<!-- PROJECT LOGO -->
<br />
<p align="center">
  <h3 align="center">GirlPower &lt;Code/&gt; </h3>
    <h5 align="center">WishList </h5>

  <p align="center">
    REST API desenvolvida para projeto final do curso da Luiza Code.
    <br />
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Conteúdo</summary>
  <ol>
    <li>
      <a href="#about-the-project">Sobre o projeto</a>
      <ul>
        <li><a href="#built-with">Tecnologias utilizadas</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Começando</a>
      <ul>
        <li><a href="#installation">Instalando</a></li>
      </ul>
    </li>
    <li><a href="#usage">Uso</a></li>
    <li><a href="#contact">Contatos</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## Sobre o projeto

A API de Wishlist centraliza informações sobre wishlist de clientes. Permitindo que os usuários consigam fazer cadastros e acesso às informações conforme for solicitado.

![swagger-completo-screenshot][swagger-completo-screenshot]


A arquitetura do projeto é formada por:
* EndPoints que podem ser usados por uma aplicação FrontEnd
* Testes unitários de funcionalidades básicas do projeto
* Exemplo de um database simples, porém com relacionamentos do tipo OneToOne e ManyToMany


### Tecnologias utilizadas

O projeto foi criado usando as seguintes tecnologias:
* Java 11
* Spring framework
* Banco de dados MySQL
* Heroku
* Intellij

Para organização das atividades e divisão de tarefas usou-se:
* Trello
* Serviços do google


<!-- GETTING STARTED -->
## Começando

Siga as instruções para executar a API.

### Instalando

1. Clone o repositório
   ```sh
   git clone https://github.com/GirlPower-Code/GirlPower-Code.git
   ```
2. Navegue até a pasta listaDesejos
   ```sh
   cd listaDesejos
   ```
3. Excute o projeto por qualquer IDE
   ```sh
   run
   ```
4. Acesse os endpoints
   ```sh
   Postman / Insomnia 
   ```
5. Acesse o Swagger
   ```sh
   http://localhost:8080/swagger-ui.html
   ```

<!-- USAGE EXAMPLES -->
## Uso

Você tem acesso aos endpoints de Cliente, Produto e Wishlist

_Cliente Endpoints_
![swagger-cliente-screenshot][swagger-cliente-screenshot]

_Produto Endpoints_
![swagger-produto-screenshot][swagger-produto-screenshot]

_Wishlist Endpoints_
![swagger-wishlist-screenshot][swagger-wishlist-screenshot]

<!-- CONTACT -->
## Contatos

Alice Pizetta - [alice-pizetta](https://github.com/alice-pizetta) - alicepizetta13@hotmail.com

LinkedIn: [/alicepizzeta](https://www.linkedin.com/in/alice-pizetta/)

Carolina Ribeiro: [Cacaulribeiro](https://github.com/Cacaulribeiro) - ribeirocarolina767@gmail.com

LinkedIn: [/carolinaribeiro](https://www.linkedin.com/in/carolina-ribeiro-438b52112/)

Jacqueline Sales: [jacquesales](https://github.com/jacquesales) - tendencce@gmail.com

LinkedIn: [/jacquelinesales](https://www.linkedin.com/in/jacqueline-sales-3baaa61a8/)

Juliany Batista: [julianymsb](https://github.com/julianymsb) - julianymsb@gmail.com

LinkedIn: [/julianybatista](https://www.linkedin.com/in/julianymsb)

Raissa Vieira: [RaissaVieira](https://github.com/RaissaVieira) - raissavieira125@gmail.com

LinkedIn: [/raissavieira](http://linkedin.com/in/raissa-vieira-engenharia)

Stephani Monteiro: [stephanimonteiro](https://github.com/stephanimonteiro) - stephanimonteiro608@gmail.com

LinkedIn: [/stephanimonteiro](https://www.linkedin.com/in/stephani-monteiro-996910100)

Project Link: [https://github.com/GirlPower-Code/GirlPower-Code](https://github.com/GirlPower-Code/GirlPower-Code)



<!-- MARKDOWN LINKS & IMAGES -->
[swagger-completo-screenshot]: images/swagger-completo.png
[swagger-cliente-screenshot]: images/swagger-cliente.png
[swagger-produto-screenshot]: images/swagger-produto.png
[swagger-wishlist-screenshot]: images/swagger-wishlist.png