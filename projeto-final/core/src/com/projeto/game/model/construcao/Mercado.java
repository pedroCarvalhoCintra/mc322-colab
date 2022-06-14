package com.projeto.game.model.construcao;

public class Mercado extends Construcao {
    public Mercado(){
        super();
    }
    
    public String getTipo(){
        return "Mercado";
    }

    public Mercado buildConstrucao(){
        return new Mercado();
    }
}
