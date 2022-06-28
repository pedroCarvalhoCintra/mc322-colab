package com.projeto.game.model.evento.aleatorio;

import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.evento.IStrategyEventoAleatorio;

public class EventoAleatorioSurtoDeDengue implements IStrategyEventoAleatorio{

	public EventoAleatorioSurtoDeDengue(){

	}

	public void executarEventoAleatorio(ICidade cidade) {
		// Possivel txt: Não acordamos com uma boa notícia, prefeito... Hoje chegou o resultado da 
        // nossa pesquisa de campo para prevenção de doenças e constatamos um surto de Dengue em nossa cidade.
        // Cerca de 20 pessoas não resistiram e vieram a obito. Felizmente os caso estão diminuindo... 
		//Retira 10% do dinheiro para cobrir custos hospitalares.
        //Diminuição da população.
		cidade.setDinheiro(cidade.getDinheiro() * 0.9f);
        cidade.getPopulacao().addPopulacao(-20);
	}
}