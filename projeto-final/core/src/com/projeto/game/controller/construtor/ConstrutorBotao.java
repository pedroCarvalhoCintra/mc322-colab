package com.projeto.game.controller.construtor;

public class ConstrutorBotao implements IBuildBotao{

	private static IBuildBotao instancia;
	
	private ConstrutorBotao() {
		
	}
	
	public static IBuildBotao getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorBotao();
		}
		return instancia;
	} 
	
}
