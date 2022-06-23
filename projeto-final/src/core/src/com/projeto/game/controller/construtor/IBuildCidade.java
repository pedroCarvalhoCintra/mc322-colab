package com.projeto.game.controller.construtor;

import com.projeto.game.model.cidade.ICidade;

public interface IBuildCidade {
	public ICidade buildCidade(IBuildPopulacao construtorPopulacao, IBuildConstrucao construtorConstrucao);
}
