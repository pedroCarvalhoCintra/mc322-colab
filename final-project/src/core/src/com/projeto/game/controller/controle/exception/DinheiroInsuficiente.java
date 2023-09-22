package com.projeto.game.controller.controle.exception;

public class DinheiroInsuficiente extends ConstrucaoInvalida {

	/**
	 * Excecao levantada quando tenta-se construir uma construcao mas nao se tem os fundos necessarios.
	 * Tratada pelo Controle de Jogo, no geral.
	 */
	private static final long serialVersionUID = -4638559033943953151L;
	
	public DinheiroInsuficiente() {
		super();
	}
	
	public DinheiroInsuficiente(String message) {
		super(message);
	}
}
