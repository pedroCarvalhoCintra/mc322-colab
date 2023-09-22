package com.projeto.game.controller.controle.subcontroles.calendario;

import com.projeto.game.controller.controle.subcontroles.gui.ISubControleGui;
import com.projeto.game.model.calendario.ICalendario;
import com.projeto.game.model.construcao.IConstrucao;
import com.projeto.game.model.evento.IEvento;
import com.projeto.game.model.gerador.IConstrutorGeradorDeEventos;

public class SubControleCalendario implements ISubControleCalendario {
	static private ISubControleCalendario instancia;
	private ICalendario calendario;
	private IConstrutorGeradorDeEventos geradorDeEventos;
	private ISubControleGui subControleGui;

	private SubControleCalendario() {
		
	}
	
	public void connectCalendario(ICalendario calendario) {
		this.calendario = calendario;
	}
	
	public void addEventoConstrucao(IConstrucao construcao, int prefeituraConstruida) {
		IEvento novo = geradorDeEventos.criarEventoConstrucao(construcao, calendario.getData() + construcao.getTempoConstrucao() - prefeituraConstruida);
		calendario.addEvento(novo);
	}

	public void eventoAleatorio() {
    	IEvento eventoAleatorio = geradorDeEventos.criarEventoAleatorio(calendario.getData()+5);
    	calendario.addEvento(eventoAleatorio);
    	subControleGui.adicionarDialogoEvento(eventoAleatorio);
	}

	public void passarDia() {
    	if (calendario.getData() % 5 == 0 && calendario.getData() != 0) {
    		eventoAleatorio();
    	}
    	this.calendario.passarDia();		
	}
	public void connectGeradorEventos(IConstrutorGeradorDeEventos geradorEventos) {
		this.geradorDeEventos = geradorEventos;
	}
	
	public void connectSubControleGui(ISubControleGui subControleGui) {
		this.subControleGui = subControleGui;
	}
	
	public static ISubControleCalendario getInstancia() {
		if (instancia == null) {
			instancia = new SubControleCalendario();
		}
		
		return instancia;
	}

}
