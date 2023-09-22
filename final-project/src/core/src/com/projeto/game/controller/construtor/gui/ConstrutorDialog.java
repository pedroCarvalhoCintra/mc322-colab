package com.projeto.game.controller.construtor.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ConstrutorDialog implements IBuildDialog {
	final static private Skin SKIN = new Skin(Gdx.files.internal("Skin/skin.json"));
	private static IBuildDialog instancia;

	private ConstrutorDialog() {
		
	}
	
	public Dialog buildDialog(String titulo, float largura, float altura) {
		Dialog dialogo = new Dialog(titulo, SKIN);
		dialogo.setSize(largura, altura);
		return dialogo;
	}
	
	public static IBuildDialog getInstancia() {
		if (instancia == null) {
			instancia = new ConstrutorDialog();
		}
		return instancia;
	}
}
