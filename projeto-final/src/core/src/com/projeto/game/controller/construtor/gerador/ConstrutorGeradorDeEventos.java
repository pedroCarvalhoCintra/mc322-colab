package com.projeto.game.controller.construtor.gerador;

import com.projeto.game.model.gerador.IFactoryGeradorDeEventos;
import com.projeto.game.model.gerador.FactoryGeradorDeEventos;

public class ConstrutorGeradorDeEventos implements IConstrutorGeradorDeEventos {
	
	private static IBuildGeradorDeEventos instancia;
	
	private ConstrutorGeradorDeEventos() {
		
	}
	
	public IFactoryGeradorDeEventos buildGeradorDeEventos() {
		IFactoryGeradorDeEventos geradorDeEventos =  FactoryGeradorDeEventos.getInstancia();
		return geradorDeEventos;
	}
	
	public static IBuildGeradorDeEventos getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorGeradorDeEventos();
		}
		return instancia;
	} 
}
