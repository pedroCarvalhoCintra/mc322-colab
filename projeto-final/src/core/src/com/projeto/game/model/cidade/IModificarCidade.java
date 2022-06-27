package com.projeto.game.model.cidade;

import com.projeto.game.model.construcao.IConstrucao;

public interface IModificarCidade {
	public void adicionarConstrucao(IConstrucao construcao);
	public void removerConstrucao(int linha, int coluna);
}
