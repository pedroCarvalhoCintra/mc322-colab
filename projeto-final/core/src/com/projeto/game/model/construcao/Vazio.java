package com.projeto.game.model.construcao;

public class Prefeitura extends Construcao {
    public Vazio(int linha, int coluna, int dificuldade){
        super(linha, coluna, dificuldade);
    }

    public String getTipo(){
        return "Vazio";
    }

}
