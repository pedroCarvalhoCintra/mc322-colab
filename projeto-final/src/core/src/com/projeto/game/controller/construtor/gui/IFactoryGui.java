package com.projeto.game.controller.construtor.gui;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public interface IFactoryGui extends IRControle {
	public Button criarBotao(String tipo, String texto, float largura, float altura, int linha, int coluna);
	public Window criarJanela(String tipo, String titulo, String texto, float largura, float altura, int linha, int coluna);
	public Label criarLabel(String texto, float tamanhoFonte, String estilo);
	public Dialog criarDialog(String titulo, String texto, float tamanhoFonte, float largura, float altura);
}