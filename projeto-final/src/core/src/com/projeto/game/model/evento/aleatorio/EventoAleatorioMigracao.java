package com.projeto.game.model.evento.aleatorio;

import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.evento.IStrategyEventoAleatorio;

public class EventoAleatorioMigracao implements IStrategyEventoAleatorio{

	public EventoAleatorioMigracao(){

	}
	
	public void executarEventoAleatorio(ICidade cidade) {
		cidade.getPopulacao().addPopulacao(150);
	}
}
