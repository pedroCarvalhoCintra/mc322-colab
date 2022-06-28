package com.projeto.game.model.evento.aleatorio;

import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.evento.IStrategyEventoAleatorio;

public class EventoAleatorioFestaDeMeioAno implements IStrategyEventoAleatorio{

	public EventoAleatorioFestaDeMeioAno(){

	}

	public void executarEventoAleatorio(ICidade cidade) {
		// Possivel txt: Como assim você nunca ouviu falar das festas de meio do ano ? É muito popular... 
		//  em algum lugar do planeta eu aposto. Bom você não tem escolha, o povo GRITA por uma festinha!! 
		//Retira 9% do dinheiro para cobrir custos das festas.
		cidade.setDinheiro(cidade.getDinheiro() * 0.91f);
	}
}