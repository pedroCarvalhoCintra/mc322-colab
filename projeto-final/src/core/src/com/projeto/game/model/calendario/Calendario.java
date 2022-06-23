package com.projeto.game.model.calendario;

import java.util.ArrayList;
import com.projeto.game.controller.construtor.IConstrutor;
import com.projeto.game.model.evento.IEvento;
import com.projeto.game.model.gerador.IGerador;

public class Calendario implements ICalendario {
	//Singleton
	private static ICalendario instancia;
	private IConstrutor construtor;
	private IGerador gerador;
	private ArrayList<IEvento> eventos;
	private int diaAtual;
	
	private Calendario() {
		this.diaAtual = 0;
		this.eventos = new ArrayList<IEvento>();
	}

	public void connectConstrutor(IConstrutor construtor) {
		this.construtor = construtor;
	}

	public void connectGerador(IGerador gerador) {
		this.gerador = gerador;
	}

	public void passarDia() {
		this.diaAtual += 1;
		executarEventos();
	}

	public void executarEventos() {
		for (IEvento evento: eventos) {
			if (evento.getData() == this.diaAtual) {
				evento.executarEvento();
			}
		}
	}
	
	public static ICalendario getInstancia() {
		if (instancia == null) {
			instancia = new Calendario();
		}
		return instancia;
	}	
}
