package com.projeto.game.controller.construtor.gerador;

import com.projeto.game.model.gerador.IFactoryGeradorDeEventos;
import com.projeto.game.model.gerador.FactoryGeradorDeEventos;

public class ConstrutorFactoryGeradorDeEventos implements IConstrutorFactoryGeradorDeEventos {
	
	private static IConstrutorFactoryGeradorDeEventos instancia;
	
	private ConstrutorFactoryGeradorDeEventos() {
		
	}
	
	public IFactoryGeradorDeEventos buildGeradorDeEventos() {
		IFactoryGeradorDeEventos geradorDeEventos =  FactoryGeradorDeEventos.getInstancia();
		return geradorDeEventos;
	}
	
	public static IConstrutorFactoryGeradorDeEventos getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorFactoryGeradorDeEventos();
		}
		return instancia;
	} 
}
