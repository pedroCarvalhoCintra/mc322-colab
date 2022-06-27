package com.projeto.game.model.calendario;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.projeto.game.controller.construtor.construcoes.IFactoryConstrucao;
import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.evento.IEvento;
import com.projeto.game.model.gerador.IFactoryGeradorDeEventos;

public class Calendario implements ICalendario {
	final static Texture ICONE_CHEIO = new Texture(Gdx.files.internal("Sprites/icon_time_full.png"));
	final static Texture ICONE_METADE = new Texture(Gdx.files.internal("Sprites/icon_time_half.png"));
	final static Texture ICONE_VAZIO = new Texture(Gdx.files.internal("Sprites/icon_time_empty.png"));
	
	//Singleton
	private static ICalendario instancia;
	private IFactoryConstrucao construtor;
	private IFactoryGeradorDeEventos gerador;
	private ICidade cidade;
	private ArrayList<IEvento> eventos;
	private int diaAtual;
	private int tempoLimite;
	
	private Label texto;
	
	private Calendario() {
		this.diaAtual = 0;
		this.tempoLimite = 100;
		this.eventos = new ArrayList<IEvento>();
	}

	public void connectConstrutor(IFactoryConstrucao construtor) {
		this.construtor = construtor;
	}

	public void connectGerador(IFactoryGeradorDeEventos gerador) {
		this.gerador = gerador;
	}
	
	public void connectCidade(ICidade cidade) {
		this.cidade = cidade;
	}

	public void passarDia() {
		this.diaAtual += 15;
		executarEventos();
	}

	public void executarEventos() {
		for (IEvento evento: eventos) {
			if (evento.getData() == this.diaAtual) {
				evento.executarEvento(cidade);
			}
		}
	}
	
    public void setLabel(Label label) {
    	this.texto = label;
    }
    
    public Label getLabel() {
    	return this.texto;
    }
	
	public Group criarCalendarioVisual() {
		Group grupo = new Group();
    	Image icone;
    	
    	texto.setText(String.valueOf(diaAtual) + "/" + String.valueOf(tempoLimite));
    	
    	if (tempoLimite - diaAtual <= 15) {
    		icone = new Image(ICONE_VAZIO);
    	}
    	
    	else if (tempoLimite - diaAtual <= 45) {
    		icone = new Image(ICONE_METADE);
    	}
    	
    	else {
    		icone = new Image(ICONE_CHEIO);
    	}
    	
    	icone.scaleBy(5);
    	texto.setPosition(115, 50);
    	
    	grupo.addActor(icone);
    	grupo.addActor(texto);
		
		return grupo;
	}
	
	public static ICalendario getInstancia() {
		if (instancia == null) {
			instancia = new Calendario();
		}
		return instancia;
	}	
}
