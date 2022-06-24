package com.projeto.game.model.gerador;

import com.projeto.game.model.evento.EventoConstrucao;
import com.projeto.game.model.construcao.IConstrucao;

public interface IGerarEventoConstrucao {
    public EventoConstrucao gerarEventoConstrucao(IConstrucao construcao, int data);
}