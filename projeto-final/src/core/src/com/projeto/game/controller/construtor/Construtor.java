package com.projeto.game.controller.construtor;

import com.projeto.game.model.cidade.Cidade;
import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.construcao.Escola;
import com.projeto.game.model.construcao.Hospital;
import com.projeto.game.model.construcao.IConstrucao;
import com.projeto.game.model.construcao.Industria;
import com.projeto.game.model.construcao.Mercado;
import com.projeto.game.model.construcao.Moradia;
import com.projeto.game.model.construcao.Prefeitura;
import com.projeto.game.model.construcao.Vazio;
import com.projeto.game.model.populacao.IPopulacao;
import com.projeto.game.model.populacao.Populacao;


public class Construtor implements IConstrutor {
	private int dificuldade;
	
	public ICidade buildCidade() {
		ICidade cidade = new Cidade();
		IConstrucao[][] layout = new IConstrucao[10][10];
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				layout[i][j] = buildVazio();
			}
		}
		
		cidade.connectPopulacao(buildPopulacao());
		cidade.setLayout(layout);
		
		return cidade;
	}
	
	public Escola buildEscola() {
		
	}
	
	public Hospital buildHospital() {
		
	}
	
	public Industria buildIndustria() {
		
	}
	
	public Mercado buildMercado() {
		
	}
	
	public Moradia buildMoradia() {
		
	}
	
	public Prefeitura buildPrefeitura() {
		
	}
	
	public Vazio buildVazio() {
		
	}
	
	public IPopulacao buildPopulacao() {
		IPopulacao populacao =  new Populacao();
		
		return populacao;
	}
}
