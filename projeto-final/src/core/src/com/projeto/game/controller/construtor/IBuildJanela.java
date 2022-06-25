package com.projeto.game.controller.construtor;

import com.badlogic.gdx.scenes.scene2d.ui.Window;

public interface IBuildJanela {
	public Window buildJanelaTexto(String titulo, float largura, float altura);
	public Window buildJanelaConstrucoes(String titulo, float largura, float altura);
}
