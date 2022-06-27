package com.projeto.game.controller.construtor.gui;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public interface IBuildBotao extends IRControle {
	public Button buildBotaoTexto(String texto, float largura, float altura);
	public Button buildBotaoImagemVazio(float largura, float altura);
	public Button buildBotaoImagem(TextureRegionDrawable image, float largura, float altura, int linha, int coluna, String tipo);
	public Button buildBotaoDestruir(String texto, float largura, float altura, int linha, int coluna, String tipo);

}
