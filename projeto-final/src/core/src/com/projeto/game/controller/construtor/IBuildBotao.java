package com.projeto.game.controller.construtor;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public interface IBuildBotao {
	public Button buildBotaoTexto(String input, float largura, float altura);
	public Button buildBotaoImagemVazio(float largura, float altura);
	public Button buildBotaoImagem(TextureRegionDrawable image, float largura, float altura);

}
