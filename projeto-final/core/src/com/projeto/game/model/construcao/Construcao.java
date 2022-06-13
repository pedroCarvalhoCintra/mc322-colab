package com.projeto.game.model.construcao;

public abstract class Construcao implements IConstrucao {
    private int linha;
    private int coluna;
    private int dificuldade;

    public Construcao (int linha, int coluna, int dificuldade){
        this.linha = linha;
        this.coluna = coluna;
        this.dificuldade = dificuldade;
    }

    public int getLinha(){
        return this.linha;
    }

    public int getColuna(){
        return this.linha;
    }

    public int getDificuldade(){
        return this.dificuldade;
    }

    public void setLinha(int linha){
        this.linha = linha;
    }

    public void setColuna(int coluna){
        this.coluna = coluna;
    }

    public abstract buildConstrução(int linha, int coluna. int dificuldade);
    public abstract String getTipo();
    public abstract double getPreco();
    public abstract double getRenda();
    public abstract int getSatisfacao(); 
    
}
