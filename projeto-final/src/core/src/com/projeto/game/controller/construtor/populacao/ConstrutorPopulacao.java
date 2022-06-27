package com.projeto.game.controller.construtor.populacao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.model.populacao.IPopulacao;
import com.projeto.game.model.populacao.Populacao;

public class ConstrutorPopulacao implements IConstrutorPopulacao {
	final static private Skin SKIN = new Skin(Gdx.files.internal("Skin/skin.json"));
	private static IConstrutorPopulacao instancia;
	private IFactoryGui construtorGui;

	private ConstrutorPopulacao() {
		
	}
	
	public void connect(IFactoryGui construtorGui) {
		this.construtorGui = construtorGui;
	}
	
	public IPopulacao buildPopulacao() {
		IPopulacao populacao =  Populacao.getInstancia();
		Label label = construtorGui.criarLabel("", 2, "white");
		populacao.setLabel(label);
		return populacao;
	}
	
	public static IConstrutorPopulacao getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorPopulacao();
		}
		return instancia;
	} 
	
	
	
}
