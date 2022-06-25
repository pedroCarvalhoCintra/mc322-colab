package com.projeto.game.controller.construtor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class ConstrutorJanela implements IBuildJanela {
	final static private Skin SKIN = new Skin(Gdx.files.internal("Skin/uiskin.json"));
	private static IBuildJanela instancia;
	
	private ConstrutorJanela() {
		
	}
	
	public Window buildJanelaTexto(String titulo, float largura, float altura) {
		Window janela = new Window(titulo, SKIN);
		
		janela.setSize(altura, largura);
		janela.setVisible(false);
		
		return janela;
	}
	
	public Window buildJanelaConstrucoes(String titulo, float largura, float altura) {
		Window janela = new Window(titulo, SKIN);
		
		janela.setSize(largura, altura);
		janela.setVisible(false);
		
		return janela;
	}
	
	public static IBuildJanela getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorJanela();
		}
		return instancia;
	} 
}
