package com.projeto.game.controller.construtor.cidade;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.projeto.game.controller.construtor.construcoes.IFactoryConstrucao;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.controller.construtor.populacao.IConstrutorPopulacao;
import com.projeto.game.model.cidade.Cidade;
import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.construcao.IConstrucao;

public class ConstrutorCidade implements IConstrutorCidade {

	private static IConstrutorCidade instancia;
	private IConstrutorPopulacao construtorPopulacao;
	private IFactoryConstrucao construtorConstrucao;
	private IFactoryGui construtorGui;
	
	private ConstrutorCidade() {
		
	}
	
	public ICidade buildCidade() {
		ICidade cidade = new Cidade();
		IConstrucao[][] layout = new IConstrucao[10][10];
		Label label = construtorGui.criarLabel("", 2, "white");
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				layout[i][j] = construtorConstrucao.criarConstrucao("vazio", i, j);
			}
		}
		
		cidade.connectPopulacao(construtorPopulacao.buildPopulacao());
		cidade.setLayout(layout);
		cidade.setDinheiro(1000);
		cidade.setLabel(label);
		cidade.setRenda(0);
		return cidade;
	}

	public void connectConstrutorConstrucao(IFactoryConstrucao construtorConstrucao) {
		this.construtorConstrucao = construtorConstrucao;
	}

	public void connectConstrutorGui(IFactoryGui construtorGui) {
		this.construtorGui = construtorGui;
	}

	public void connectConstrutorPopulacao(IConstrutorPopulacao construtorPopulacao) {
		this.construtorPopulacao = construtorPopulacao;
	}

	public static IConstrutorCidade getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorCidade();
		}
		return instancia;
	}
}
