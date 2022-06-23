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
    
    public static IPopulacao getInstancia() {
    	if ( instancia == null ) {
    		instancia = new Populacao();
    	}
    	return instancia;
    }
}
