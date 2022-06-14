package com.projeto.game.model.construcao;

public class Escola extends Construcao {
    public Escola(){
        super();
    }

    public String getTipo(){
        return "Escola";
    }

    public Escola buildConstrucao(){
        return new Escola();
    }
}
