package com.projeto.game.model.evento.aleatorio;

import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.evento.IStrategyEventoAleatorio;

public class EventoAleatorioAgenda2030 implements IStrategyEventoAleatorio{

	public EventoAleatorioAgenda2030(){

	}

	public void executarEventoAleatorio(ICidade cidade) {
		// Possivel txt: Recebemos uma notícia ótima prefeito!! A nossa agenda para tornar a cidade mais
        // sustentável e a luta contra a poluição urbana está a todo vapor. Mas para isso precimos investir...
        // investir em um mundo melhor e mais limpo.
		//Retira 27% do dinheiro para cobrir custos das inovações sustentáveis.
        //Mais habitantes querem morar aqui.
		cidade.setDinheiro(cidade.getDinheiro() * 0.73f);
        cidade.getPopulacao().addPopulacao(250);
	}
}