package com.projeto.game.model.evento.aleatorio;

import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.evento.IStrategyEventoAleatorio;

public class EventoAleatorioApagao implements IStrategyEventoAleatorio{
	
	public EventoAleatorioApagao() {
		
	}
	
	public void executarEventoAleatorio(ICidade cidade) {
		/*	Apagão na cidade. Infelizmente nossa distribuidora de energia nos deixou na mão... no útlimo sabado algo aconteceu na 
		 * central, algum roedor cortou os fios, algo do tipo .... Isso que dá contratar seviços de segunda, senhor prefeito... agora vamo passar 
		 * dois dias inteiros no escuro até encontrarmos outra distribuidora. Os habitantes não vão gostar disso...
		 */
		//Retira 10% do dinheiro para cobrir gastos na nova contratação.
        //População insatistfeita
		cidade.setDinheiro(cidade.getDinheiro() * 0.9f);
        cidade.getPopulacao().addPopulacao(250);
}
