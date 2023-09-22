package com.projeto.game.model.evento.aleatorio;

import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.evento.IStrategyEventoAleatorio;

public class EventoAleatorioVerao implements IStrategyEventoAleatorio{

	public EventoAleatorioVerao(){

	}

	public void executarEventoAleatorio(ICidade cidade) {
		/* CALOR ESCALDANTE NA CIDADE!! Não viamos um verão tão quente em algum tempo... e junto com todo o calor e 
		 * agitação também chega as fomosas férias de verão. Toda a família pode se divertir com festas de piscina, 
		 * churrasquinho ou tomar aquele sorvete na praça. É tempo de curtir e aproveitar as férias.. menos você, 
		 * chegou mais papelada pra ser entrega na proxima terça-feria :)
		 */
		//Retira 27% do dinheiro para cobrir custos das inovações sustentáveis.
        //População mais alegre.
        cidade.getPopulacao().addSatisfacao(15);
	}
}
