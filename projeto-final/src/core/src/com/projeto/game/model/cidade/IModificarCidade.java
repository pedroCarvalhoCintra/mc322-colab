package com.projeto.game.model.cidade;

import com.projeto.game.model.construcao.IConstrucao;

public interface IModificarCidade {
	public boolean adicionarConstrucao(IConstrucao construcao);
	public boolean removerConstrucao(int linha, int coluna);
}
