package com.projeto.game.model.gerador;

import com.projeto.game.model.evento.IEvento;
import com.projeto.game.model.construcao.IConstrucao;

public interface IFactoryGeradorDeEventos {
	public IEvento criarEventoAleatorio(int data);
    public IEvento criadorEventoConstrucao(IConstrucao construcao, int data);
}
