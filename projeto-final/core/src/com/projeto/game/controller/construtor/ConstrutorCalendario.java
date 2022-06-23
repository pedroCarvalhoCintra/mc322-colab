package com.projeto.game.controller.construtor;

import com.projeto.game.model.calendario.Calendario;
import com.projeto.game.model.calendario.ICalendario;

public class ConstrutorCalendario implements IBuildCalendario{
	
	private static IBuildCalendario instancia;
	
	private ConstrutorCalendario() {
		
	}
	
	public ICalendario buildCalendario() {
		ICalendario calendario =  Calendario.getInstancia();
		return calendario;
	}
	
	
	public static IBuildCalendario getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorCalendario();
		}
		return instancia;
	} 
	

}
