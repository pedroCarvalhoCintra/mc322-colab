package com.projeto.game.controller.construtor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ConstrutorLabel implements IBuildLabel{
	final static private Skin SKIN = new Skin(Gdx.files.internal("Skin/uiskin.json"));
	private static IBuildLabel instancia;
	
	private ConstrutorLabel() {
		
	}

	public Label criarLabel(String texto, float tamanhoFonte) {
		Label label = new Label(texto, SKIN);
		label.setFontScale(tamanhoFonte);
		return label;
	}
	
	public static IBuildLabel getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorLabel();
		}
		return instancia;
	} 
}
