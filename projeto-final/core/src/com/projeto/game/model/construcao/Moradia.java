package com.projeto.game.model.construcao;

public class Moradia extends Construcao {
    public Moradia(int linha, int coluna, int dificuldade){
        super(linha, coluna, dificuldade);
    }

    public String getTipo(){
        return "Moradia";
    }

    public Moradia buildConstrução(int linha, int coluna, int dificuldade){
        return new Moradia(linha, coluna, dificuldade)
    }

    public double getPreco()(
        switch (dificuldade) {
            case 1:
                return 1;        
                break;
            case 2:
                return 2;
                break;
            case 3:
                return 3;
                break;
        }
        
    )

    public double getRenda(){
        switch (dificuldade) {
            case 1:
                return 1;        
                break;
            case 2:
                return 2;
                break;
            case 3:
                return 3;
                break;
        }
    }

    public int getSatisfacao(){
        switch (dificuldade) {
            case 1:
                return 1;        
                break;
            case 2:
                return 2;
                break;
            case 3:
                return 3;
                break;
        }
    }
}
