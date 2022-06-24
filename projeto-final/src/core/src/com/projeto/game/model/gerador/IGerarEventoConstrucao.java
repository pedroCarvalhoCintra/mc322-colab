package com.projeto.game.model.gerador;

import com.projeto.game.model.evento.IEvento;
import com.projeto.game.model.construcao.IConstrucao;

public interface IGerarEventoConstrucao {
    public IEvento gerarEventoConstrucao(IConstrucao construcao, int data);
}