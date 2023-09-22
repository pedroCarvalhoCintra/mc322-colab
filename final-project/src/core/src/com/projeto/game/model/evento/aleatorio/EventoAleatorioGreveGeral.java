package com.projeto.game.model.evento.aleatorio;

import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.evento.IStrategyEventoAleatorio;

public class EventoAleatorioGreveGeral implements IStrategyEventoAleatorio{

	public EventoAleatorioGreveGeral(){

	}

	public void executarEventoAleatorio(ICidade cidade) {
		//Retira 20% do dinheiro para cobrir custos da greve.
		cidade.setDinheiro(cidade.getDinheiro() * 0.8f);
	}
}