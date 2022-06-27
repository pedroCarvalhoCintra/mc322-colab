package com.projeto.game.view.cidade;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.model.cidade.ICidade;

public class ViewCidade implements IViewCidade {
	private ICidade cidade;
	
	public Table getVisual(Stage stage, IFactoryGui factoryGui) {
		return cidade.criarCidadeVisual(stage, factoryGui);
	}
	
	public void connectCidade(ICidade cidade) {
		this.cidade = cidade;
	}
    
}