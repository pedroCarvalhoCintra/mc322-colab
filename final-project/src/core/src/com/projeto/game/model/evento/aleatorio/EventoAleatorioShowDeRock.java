package com.projeto.game.model.evento.aleatorio;

import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.evento.IStrategyEventoAleatorio;

public class EventoAleatorioShowDeRock implements IStrategyEventoAleatorio{

	public EventoAleatorioShowDeRock(){

	}

	public void executarEventoAleatorio(ICidade cidade) {
		// Possivel txt: ROCK AND ROOL!!!! Parece que houve um show de rock beneficente na cidade, prefeito. 
		// Infelizmente so ficamos sabendo disso depois, seria um bom evento para os funcionários 
		// publicos você não acha ? Não ? Ok, não custa tentar. Vizinhos do lado gostaram tanto da ação que 
		// acabaram se mundado para nossa cidade, que virará sede desse evento. Com a sua permissão claro...
		// ha eu já dissse que sim se não se importar :) ....
        //Aumento da população.
        cidade.getPopulacao().addPopulacao(300);
	}
}