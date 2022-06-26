package com.projeto.game.model.populacao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class Populacao implements IPopulacao{
	final static Texture ICONE_FELIZ = new Texture(Gdx.files.internal("Sprites/icon_happy.png"));
	final static Texture ICONE_SORRISO = new Texture(Gdx.files.internal("Sprites/icon_smile.png"));
	final static Texture ICONE_CARRANCA = new Texture(Gdx.files.internal("Sprites/icon_frown.png"));
	final static Texture ICONE_BRAVO = new Texture(Gdx.files.internal("Sprites/icon_angry.png"));
	
    private Label texto;
	
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
    	
    	else if (novaSatisfacao > 100) {
    		novaSatisfacao = 100;
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
    
    public void setLabel(Label label) {
    	this.texto = label;
    }
    
    public Label getLabel() {
    	return this.texto;
    }
    
    public Group criarPopulacaoVisual() {
    	Group grupo = new Group();
    	Image icone;
    	
    	texto.setText(String.valueOf(satisfacao));
    	
    	if (satisfacao <= 15) {
    		icone = new Image(ICONE_BRAVO);
    	}
    	
    	else if (satisfacao <= 35) {
    		icone = new Image(ICONE_CARRANCA);
    	}
    	
    	else if (satisfacao <= 80) {
    		icone = new Image(ICONE_SORRISO);
    	}
    	
    	else {
    		icone = new Image(ICONE_FELIZ);
    	}
    	
    	icone.scaleBy(5);
    	texto.setPosition(115, 50);
    	
    	return grupo;
    }

    public static IPopulacao getInstancia() {
    	if ( instancia == null ) {
    		instancia = new Populacao();
    	}
    	return instancia;
    }
}
