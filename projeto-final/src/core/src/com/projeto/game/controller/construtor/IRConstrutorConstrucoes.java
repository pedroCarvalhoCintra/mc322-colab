package com.projeto.game.controller.construtor;

import com.projeto.game.model.construcao.IConstrucao;

public interface IRConstrutorConstrucoes {
	public IConstrucao criarConstrucao(String tipo, int linha, int coluna);
}
