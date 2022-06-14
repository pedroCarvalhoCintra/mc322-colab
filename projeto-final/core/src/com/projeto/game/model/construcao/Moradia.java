package com.projeto.game.model.construcao;

public class Moradia extends Construcao {
    public Moradia(){
        super();
    }

    public String getTipo(){
        return "Moradia";
    }

    public Moradia buildConstrucao(){
        return new Moradia();
    }
}
