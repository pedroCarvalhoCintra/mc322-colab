package com.projeto.game.model.populacao;

public class Populacao implements IPopulacao{
    
    private static IPopulacao instancia;
    private int numHabitantes;
    private int satisfacao;
    private double rendaPopulacao;

    public Populacao(){
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
    
    public void addPopulacao(int num) {
    	int novaPop = numHabitantes + num;
    	
    	if (novaPop < 0) {
    		novaPop = 0;
    	}
    	
    	this.numHabitantes = novaPop;
    }
    
    public static IPopulacao getInstancia() {
    	if ( instancia == null ) {
    		instancia = new Populacao();
    	}
    	return instancia;
    }
}
