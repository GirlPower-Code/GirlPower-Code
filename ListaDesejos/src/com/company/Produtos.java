package com.company;

public class Produtos {

    String nome;
    double preço;

    public Produtos(String nome, double preço) {
        this.nome = nome;
        this.preço = preço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public void info(){
        System.out.println("Nome: "+this.nome+" Preço: "+this.preço);
    }


}
