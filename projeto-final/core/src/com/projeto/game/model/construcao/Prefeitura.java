package com.projeto.game.model.construcao;

public class Prefeitura extends Construcao {
    public Prefeitura(){
        super();
    }

    public String getTipo(){
        return "Prefeitura";
    }

    public Prefeitura buildConstrucao(){
        return new Prefeitura();
    }
}
