package com.projeto.game.view.populacao;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.projeto.game.model.populacao.IPopulacao;

public class ViewPopulacao implements IViewPopulacao {
	private IPopulacao populacao;
	
	
	public void connect(IPopulacao populacao) {
		this.populacao = populacao;
	}

	public Group getVisual() {
		Group grupo = populacao.criarPopulacaoVisual();
		return grupo;
	}
    
}