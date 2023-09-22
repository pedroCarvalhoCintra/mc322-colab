package com.projeto.game.controller.construtor.gerador;

import com.projeto.game.model.gerador.IConstrutorGeradorDeEventos;
import com.projeto.game.model.gerador.ConstrutorGeradorDeEventos;

public class ConstrutorConstrutorGeradorDeEventos implements IConstrutorConstrutorGeradorDeEventos {
	
	private static IConstrutorConstrutorGeradorDeEventos instancia;
	
	private ConstrutorConstrutorGeradorDeEventos() {
		
	}
	
	public IConstrutorGeradorDeEventos buildGeradorDeEventos() {
		IConstrutorGeradorDeEventos geradorDeEventos = ConstrutorGeradorDeEventos.getInstancia();
		return geradorDeEventos;
	}
	
	public static IConstrutorConstrutorGeradorDeEventos getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorConstrutorGeradorDeEventos();
		}
		return instancia;
	} 
}
