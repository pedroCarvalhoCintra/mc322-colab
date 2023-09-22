package com.projeto.game.model.cidade;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.projeto.game.model.construcao.IConstrucao;
import com.projeto.game.model.populacao.IPopulacao;

public interface ICidadeProperties {
	public float getDinheiro();
	public IConstrucao[][] getLayout();
	public void setLayout(IConstrucao[][] layout);
	public IPopulacao getPopulacao();
	public void setDinheiro(float dinheiro);
	public void setLabel(Label label);
	public Label getLabel();
	public float getRenda();
	public void setRenda(float renda);
}
