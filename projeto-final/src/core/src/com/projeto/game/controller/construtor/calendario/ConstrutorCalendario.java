package com.projeto.game.controller.construtor.calendario;

import com.projeto.game.model.calendario.Calendario;
import com.projeto.game.model.calendario.ICalendario;

public class ConstrutorCalendario implements IConstrutorCalendario {
	
	private static IConstrutorCalendario instancia;
	
	private ConstrutorCalendario() {
		
	}
	
	public ICalendario buildCalendario() {
		ICalendario calendario =  Calendario.getInstancia();
		return calendario;
	}
	
	public static IConstrutorCalendario getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorCalendario();
		}
		return instancia;
	} 
	

}
