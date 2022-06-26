package com.projeto.game.view.cidade;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.projeto.game.model.cidade.ICidade;

public class ViewCidade implements IViewCidade {
	private ICidade cidade;
	private Table layoutVisual;
	
	public Table getVisual(Stage stage) {
		layoutVisual = cidade.criarCidadeVisual(stage);
		return layoutVisual;
	}
	
	public void connectCidade(ICidade cidade) {
		this.cidade = cidade;
	}
    
}