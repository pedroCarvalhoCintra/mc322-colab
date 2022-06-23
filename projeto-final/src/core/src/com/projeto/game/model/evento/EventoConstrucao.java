package com.projeto.game.model.evento;

import com.projeto.game.model.construcao.IConstrucao;

public class EventoConstrucao extends Evento {
	private IConstrucao construcao;
	
	public void connectConstrucao(IConstrucao construcao) {
		this.construcao = construcao;
	}
	
	public void executarEvento() {
		construcao.setConstruido(true);
	}
}
