package com.projeto.game.controller.construtor.populacao;

import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.model.populacao.IPopulacao;
import com.projeto.game.model.populacao.Populacao;

public class ConstrutorPopulacao implements IConstrutorPopulacao {
	
	private static IConstrutorPopulacao instancia;
	private IFactoryGui construtorGui;

	private ConstrutorPopulacao() {
		
	}
	
	public void connect(IFactoryGui construtorGui) {
		this.construtorGui = construtorGui;
	}
	
	public IPopulacao buildPopulacao() {
		IPopulacao populacao =  Populacao.getInstancia();
		populacao.setLabel(construtorGui.criarLabel("", 2));
		return populacao;
	}
	
	public static IConstrutorPopulacao getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorPopulacao();
		}
		return instancia;
	} 
	
	
	
}
