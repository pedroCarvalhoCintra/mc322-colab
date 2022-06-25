package com.projeto.game.controller.construtor;

import com.projeto.game.model.cidade.Cidade;
import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.construcao.IConstrucao;

public class ConstrutorCidade implements IBuildCidade{

	private static IBuildCidade instancia;
	
	private ConstrutorCidade() {
		
	}
	
	public ICidade buildCidade(IBuildPopulacao construtorPopulacao, IBuildConstrucao construtorConstrucao) {
		ICidade cidade = new Cidade();
		IConstrucao[][] layout = new IConstrucao[10][10];
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				layout[i][j] = construtorConstrucao.buildVazio(int linha, int coluna);
			}
		}
		
		cidade.connectPopulacao(construtorPopulacao.buildPopulacao());
		cidade.setLayout(layout);
		
		return cidade;
	}
	
	public static IBuildCidade getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorCidade();
		}
		return instancia;
	} 
}
