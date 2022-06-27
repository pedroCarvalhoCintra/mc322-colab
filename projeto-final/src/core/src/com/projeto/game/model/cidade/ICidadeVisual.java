package com.projeto.game.model.cidade;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.projeto.game.controller.construtor.gui.IFactoryGui;

public interface ICidadeVisual {
	public Table criarCidadeVisual(Stage stage, IFactoryGui factoryGui);
}
