package com.projeto.game.view.cidade;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.view.construcao.IViewConstrucao;
import com.projeto.game.view.construcao.ViewConstrucao;

public class ViewCidade implements IViewCidade {
	private ICidade cidade;
	
	public Table getVisual(Stage stage, IFactoryGui factoryGui) {
		Table tabela = cidade.criarCidadeVisual();
		for (int i = 0; i < 10; i ++) {
			for (int j = 0; j < 10; j ++) {
				IViewConstrucao construcao = new ViewConstrucao();
				construcao.connect(cidade.getLayout()[i][j]);
				construcao.connectGui(factoryGui);
				tabela.add(construcao.getVisual()).expand();
				construcao.connectStage(stage);
			}
			tabela.row();
		}
		return tabela; 
	}
	
	public Group getDinheiroVisual() {
		Group grupo = cidade.criarDinheiroVisual();
		return grupo;
	}
	
	public void connectCidade(ICidade cidade) {
		this.cidade = cidade;
	}
    
}