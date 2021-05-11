package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente {
   private String nome;
   private String cpf;
   private String senha;
    List<Produtos> listaPro = new ArrayList<Produtos>();
    //Produtos a ;
    //Map<Object> ListaP= new HashMap<Object>();

   public Cliente(){

   }

    public Cliente(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public  boolean addProduto(Object prod){
       listaPro.add((Produtos) prod);
        System.out.println("O produto foi adicionado");
       return true;
    }

    public void motrarProd(){
        for ( Produtos a: listaPro) a.info();
        }


}
