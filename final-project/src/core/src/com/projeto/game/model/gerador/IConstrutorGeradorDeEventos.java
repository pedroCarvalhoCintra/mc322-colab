package com.projeto.game.model.gerador;

import com.projeto.game.model.evento.IEvento;
import com.projeto.game.model.construcao.IConstrucao;

public interface IConstrutorGeradorDeEventos {
	public IEvento criarEventoAleatorio(int data);
    public IEvento criarEventoConstrucao(IConstrucao construcao, int data);
}
