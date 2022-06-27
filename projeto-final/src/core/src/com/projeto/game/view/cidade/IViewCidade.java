package com.projeto.game.view.cidade;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.projeto.game.controller.construtor.gui.IFactoryGui;

public interface IViewCidade extends IRCidade {
	public Table getVisual(Stage stage, IFactoryGui factoryGui);
}
