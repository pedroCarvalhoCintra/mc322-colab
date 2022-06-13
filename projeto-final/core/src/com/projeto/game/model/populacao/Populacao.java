package com.projeto.game.model.populacao;

public class Populacao implements IPopulacao{
    private int numHabitantes;
    private int satisfacao;
    private double rendaPopulacao;

    public Populacao(int numHabitantesIniciais){
        this.numHabitantes = numHabitantesIniciais;
        this.satisfacao = 0;
        this.satisfacao = 0;
    }

    public int getNumHabitantes(){
        return numHabitantes;
    }

    public int getSatisfacao(){
        return satisfacao;
    }

    public double getRendaPopulacao(){
        return rendaPopulacao;
    }

}
