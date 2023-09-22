package com.projeto.game.model.evento.aleatorio;

import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.evento.IStrategyEventoAleatorio;

public class EventoAleatorioEscandaloDeCorrupcao implements IStrategyEventoAleatorio{

	public EventoAleatorioEscandaloDeCorrupcao(){

	}

	public void executarEventoAleatorio(ICidade cidade) {
		// Possivel txt: Escolha melhor o seus funcionários públicos, senhor prefeito. Recentemente
		// alguns mau feitores da prefeitura foram pegos em esquema de corrupção... pouco ou muito, qualquer roubo
		// dos fundos públicos afeta diretamente a vida dos habitantes dessa cidade. Todos estamos decepcionados.
		//Retira 20% do dinheiro para cobrir ressarcir cofres públicos.
		//Retira 15% do dinheiro para cobrir despesas nas investigações e combate a corrupção.
		//Insatisfação
        //Diminuição da população.
		cidade.setDinheiro(cidade.getDinheiro() * 0.80f);
		cidade.setDinheiro(cidade.getDinheiro() * 0.85f);
		cidade.getPopulacao().addSatisfacao(-25);
        cidade.getPopulacao().addPopulacao(-200);
	}
}