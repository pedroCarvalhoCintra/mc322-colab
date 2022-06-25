package com.projeto.game.controller.construtor;

import com.badlogic.gdx.scenes.scene2d.ui.Button;

public interface IBuildBotao {
	public Button buildBotaoTexto(String input, float largura, float altura);
	public Button buildBotaoImagem(float largura, float altura);
}
