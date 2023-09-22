package com.projeto.game.model.evento.aleatorio;

import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.evento.IStrategyEventoAleatorio;

public class EventoAleatorioLixoNasRedondesas implements IStrategyEventoAleatorio{

	public EventoAleatorioLixoNasRedondesas(){

	}

	public void executarEventoAleatorio(ICidade cidade) {
		// Possivel txt: Detestável! Não é sobre o senhor prefeito, mas parece que alguns prefeitos ao lado
        // não cuida muito bem do lixo deles... Alguns carregamentos de lixo foram mau tratados e acabaram 
        // infectando um pouco nosso solo. Não agradou alguns moradores... Felizmente fomos indenizados 
        // para realizar a desinfecção.
        //Acrescenta 10% do dinheiro para cobrir gastos com a desinfecção.
        //Dimuição da população.
		cidade.setDinheiro(cidade.getDinheiro() * 1.2f);
        cidade.getPopulacao().addPopulacao(-50);
	}
}