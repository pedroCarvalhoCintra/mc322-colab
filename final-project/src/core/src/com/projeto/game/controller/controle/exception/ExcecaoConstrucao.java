package com.projeto.game.controller.controle.exception;

public class ExcecaoConstrucao extends RuntimeException {

	/**
	 * Excecao geral levantada quando houve um erro relacionado com construcoes em seus diferentes processos.
	 */
	private static final long serialVersionUID = -6816118256022571583L;
	
	public ExcecaoConstrucao() {
		super();
	}
	
	public ExcecaoConstrucao(String message) {
		super(message);
	}
}
