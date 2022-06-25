package com.projeto.game.model.populacao;

public class Populacao implements IPopulacao{
    
    private static IPopulacao instancia;
    private int numHabitantes;
    private int satisfacao;
    private double rendaPopulacao;

    public Populacao(){
        this.numHabitantes = 0;
        this.satisfacao = 0;
        this.rendaPopulacao = 0;
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
    	int novaPopulacao = numHabitantes + num;
    	
    	if (novaPopulacao < 0) {
    		novaPopulacao = 0;
    	}
    	
    	this.numHabitantes = novaPopulacao;
    }
    
    public void addSatisfacao(int num) {
    	int novaSatisfacao = satisfacao + num;
    	
    	if (novaSatisfacao < 0) {
    		novaSatisfacao = 0;
    	}
    	
    	this.satisfacao = novaSatisfacao;
    }

    public void addRenda(double num) {
    	double novaRenda = rendaPopulacao + num;
    	
    	if (novaRenda < 0) {
    		novaRenda = 0;
    	}
    	
    	this.rendaPopulacao = novaRenda;
    }

    public static IPopulacao getInstancia() {
    	if ( instancia == null ) {
    		instancia = new Populacao();
    	}
    	return instancia;
    }
}
