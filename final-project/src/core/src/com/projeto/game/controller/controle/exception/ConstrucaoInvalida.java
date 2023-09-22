package com.projeto.game.controller.controle.exception;

public class ConstrucaoInvalida extends ExcecaoConstrucao {

	/**
	 * Excecao levantada quando uma construcao invalida tentou entrar ou sair da cidade.
	 */
	private static final long serialVersionUID = 7545935402415255831L;
	
	public ConstrucaoInvalida() {
		super();
	}
	
	public ConstrucaoInvalida(String message) {
		super(message);
	}

}
