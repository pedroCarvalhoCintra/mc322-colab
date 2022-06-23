package com.projeto.game.controller.construtor;

import com.projeto.game.model.populacao.IPopulacao;
import com.projeto.game.model.populacao.Populacao;

public class ConstrutorPopulacao implements IBuildPopulacao{
	
	private static IBuildPopulacao instancia;
	
	private ConstrutorPopulacao() {
		
	}
	
	public IPopulacao buildPopulacao() {
		IPopulacao populacao =  Populacao.getInstancia();
		return populacao;
	}
	
	public static IBuildPopulacao getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorPopulacao();
		}
		return instancia;
	} 
	
	
	
}
