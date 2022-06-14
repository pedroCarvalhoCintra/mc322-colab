package com.projeto.game.model.cidade;

import com.projeto.game.model.populacao.IPopulacao;
import com.projeto.game.model.construcao.IConstrucao;


public class Cidade implements ICidade {
    private IConstrucao[][] layout;
    private IPopulacao populacao;
    private float dinheiro;

    public Cidade(){
        
    }

    public int getDinheiro() {
    	return 0;
    }

	public IConstrucao[][] getLayout() {
		return layout;
	}

	public void setLayout(IConstrucao[][] layout) {
		this.layout = layout;
	}

	public IPopulacao getPopulacao() {
		return populacao;
	}

	public void connectPopulacao(IPopulacao populacao) {
		this.populacao = populacao;
	}

	public void setDinheiro(float dinheiro) {
		this.dinheiro = dinheiro;
	}




}
