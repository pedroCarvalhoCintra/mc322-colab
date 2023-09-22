package com.projeto.game.model.calendario;

import com.projeto.game.model.evento.IEvento;

public interface IExecutarEventos {
	public void addEvento(IEvento evento);
	public void executarEventos();
}
