package com.projeto.game.controller.construtor.gui;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public interface IFactoryGui {
	public Button criarBotao(String tipo, String texto, float largura, float altura);
	public Window criarJanela(String tipo, String titulo, String texto, float largura, float altura);
	public Label criarLabel(String texto, float tamanhoFonte);
}
