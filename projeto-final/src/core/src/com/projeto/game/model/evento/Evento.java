package com.projeto.game.model.evento;

public abstract class Evento implements IEvento {
	protected int data;
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
	
	public abstract void executarEvento();
}
