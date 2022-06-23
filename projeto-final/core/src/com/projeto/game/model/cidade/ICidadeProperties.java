package com.projeto.game.model.cidade;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.projeto.game.model.construcao.IConstrucao;
import com.projeto.game.model.populacao.IPopulacao;

public interface ICidadeProperties {
	public float getDinheiro();

	public IConstrucao[][] getLayout();
	
	public Table getTable();

	public void setLayout(IConstrucao[][] layout);

	public IPopulacao getPopulacao();

	public void setDinheiro(float dinheiro);
	
	public void setTable(Table tabela);
}
