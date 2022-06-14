package com.projeto.game.model.cidade;

import com.projeto.game.model.construcao.IConstrucao;
import com.projeto.game.model.populacao.IPopulacao;

public interface ICidadeProperties {
	public int getDinheiro();

	public IConstrucao[][] getLayout();

	public void setLayout(IConstrucao[][] layout);

	public IPopulacao getPopulacao();

	public void setDinheiro(float dinheiro);
}
