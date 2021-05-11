package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //variáveis

        Scanner entrada= new Scanner(System.in);
        int escolhaProduto;

	// Criando os produtos
        Produtos panela= new Produtos("Panela", 45.78);
        Produtos celular= new Produtos("Celular",1500);
        Produtos computador= new Produtos("Compurador",4500);
        Produtos livro= new Produtos("Livro",45);
        Produtos foneOuvido= new Produtos("Fone de ouvido", 10);
        Produtos estante= new Produtos("Estante",200);
        Produtos secadorCabelo= new Produtos("Secador de cabelo",150);
        Produtos camisa= new Produtos("Camisa",49.99);
        Produtos tenis= new Produtos("Tenis",125);
        Produtos vaso= new Produtos("Vaso",24.90);

        //Criando clientes
        Cliente cliente1= new Cliente("Cacau","123", "123");
        Cliente cliente2= new Cliente("Neide", "456","456");

        //Pedindo para o cliente add produtos
        System.out.print("Escolha um produto  ");
        escolhaProduto= entrada.nextInt();

       do {
           switch (escolhaProduto) {
               case 1:
                   cliente1.addProduto(panela);
                   break;
               case 2:
                   cliente1.addProduto(celular);
                   break;
               case 3:
                   cliente1.addProduto(computador);
                   break;
               case 4:
                   cliente1.addProduto(livro);
                   break;


           }
       }while (escolhaProduto>3);



         cliente1.motrarProd();






    }
}
