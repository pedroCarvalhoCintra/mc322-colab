package com.projeto.game.model.construcao;

public class Industria extends Construcao {
    public Industria(){
        super();
    }

    public String getTipo(){
        return "Industria";
    }

    public Industria buildConstrucao(){
        return new Industria();
    }
}
