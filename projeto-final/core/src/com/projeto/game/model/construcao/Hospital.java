package com.projeto.game.model.construcao;

public class Hospital extends Construcao {
    public Hospital(){
        super();
    }

    public String getTipo(){
        return "Hospital";
    }

    public Hospital buildConstrucao(){
        return new Hospital();
    }
}
