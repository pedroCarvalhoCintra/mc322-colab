package com.projeto.game.model.evento.aleatorio;

import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.evento.IStrategyEventoAleatorio;

public class EventoAleatorioRepasseEstadual implements IStrategyEventoAleatorio{

	public EventoAleatorioRepasseEstadual(){

	}

	public void executarEventoAleatorio(ICidade cidade) {
		float valor = 0f;
		int numPop = cidade.getPopulacao().getNumHabitantes();
		
		if (numPop < 1000) {
			valor = numPop * 5f;
		}
		
		else {
			valor = numPop * 2.5f;
		}
		
		cidade.setDinheiro(cidade.getDinheiro() + valor);
	}
}
