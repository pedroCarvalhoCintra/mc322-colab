package com.projeto.game.controller.controle.exception;

public class PrefeituraInvalida extends ConstrucaoInvalida {

	/**
	 * Excecao levantada quanto tenta-se adicionar uma prefeitura numa cidade que ja tem uma prefeitura.
	 * Tratada pelo Controle de Jogo, no geral.
	 */
	private static final long serialVersionUID = -3864317346987659231L;
	
	public PrefeituraInvalida() {
		super();
	}
	
	public PrefeituraInvalida(String message) {
		super(message);
	}
}
