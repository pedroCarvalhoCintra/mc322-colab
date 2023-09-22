package com.projeto.game.model.evento;

import com.projeto.game.model.cidade.ICidade;

public class EventoAleatorio extends Evento {
	private IStrategyEventoAleatorio strategy;
	
	public void setStrategy(IStrategyEventoAleatorio strategy) {
		this.strategy = strategy;
	}

	public void executarEvento(ICidade cidade) {
		strategy.executarEventoAleatorio(cidade);
	}
}
