package com.projeto.game.model.construcao;

public class Escola extends Construcao {
    public Escola(){
        super(linha, coluna, dificuldade);
    }

    public String getTipo(){
        return "Escola";
    }

    public Escola buildConstrução(int linha, int coluna, int dificuldade){
        return new Escola(linha, coluna, dificuldade)
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
