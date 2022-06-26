package com.projeto.game.controller.construtor.construcoes;

import com.projeto.game.model.construcao.IConstrucao;

public interface IFactoryConstrucao extends IRConstrutorGui {
	public IConstrucao criarConstrucao(String tipo, int linha, int coluna);
}
