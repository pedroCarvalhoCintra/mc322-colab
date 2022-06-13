package com.projeto.game.model.construcao;

public class Prefeitura extends Construcao {
    public Prefeitura(int linha, int coluna, int dificuldade){
        super(linha, coluna, dificuldade);
    }

    public String getTipo(){
        return "Prefeitura";
    }

    public Prefeitura buildConstrução(int linha, int coluna, int dificuldade){
        return new Prefeitura(linha, coluna, dificuldade)
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
