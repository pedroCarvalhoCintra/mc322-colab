package com.projeto.game.model.evento.aleatorio;

import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.evento.IStrategyEventoAleatorio;

public class EventoAleatorioFestaDeFimDeAno implements IStrategyEventoAleatorio{

	public EventoAleatorioFestaDeFimDeAno(){

	}

	public void executarEventoAleatorio(ICidade cidade) {
		// Possivel txt: Bom dia, prefeito! Aposto que você nem percebeu mas o fim de ano está 
		// chegando, e sabe o que vem com ele ? MUITAS FESTAS!!! E seus habitantes anceiam por 
		// uma belíssima festa municipal. Boa sorte.... 
		//Retira 13% do dinheiro para cobrir custos das festas.
		cidade.setDinheiro(cidade.getDinheiro() * 0.87f);
	}
}