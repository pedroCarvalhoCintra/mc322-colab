package com.projeto.game.model.evento;

import com.projeto.game.model.cidade.ICidade;

public abstract class Evento implements IEvento {
	protected int data;
	protected String descricao;

	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
	
	public abstract void executarEvento(ICidade cidade);
}
