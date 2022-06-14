package com.projeto.game.model.construcao;

public class Vazio extends Construcao {
    public Vazio(){
        super();
    }

    public String getTipo() {
        return "Vazio";
    }
    
    public Vazio buildConstrucao() {
    	return new Vazio();
    }
}
