package com.projeto.game.model.cidade;

import com.projeto.game.model.populacao.IPopulacao;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.projeto.game.model.construcao.IConstrucao;

public class Cidade implements ICidade {
    private IConstrucao[][] layout;
    private IPopulacao populacao;
    private float dinheiro;
    private Table tabela;
    
    public Cidade(){
        
    }

    public float getDinheiro() {
    	return dinheiro;
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

	public Table getTable() {
		return this.tabela;
	}

	public void setTable(Table tabela) {
		this.tabela = tabela;
	}




}
