package com.projeto.game.model.gerador;

import com.projeto.game.model.evento.IEvento;
import com.projeto.game.model.construcao.IConstrucao;

public class ConstrutorGeradorDeEventos implements IConstrutorGeradorDeEventos {
	
	private static IConstrutorGeradorDeEventos instancia;
	final static private IGerarEventoAleatorio geradorAleatorio = GeradorEventoAleatorio.getInstancia();
	final static private IGerarEventoConstrucao geradorConstrucao = GeradorEventoConstrucao.getInstancia();

	
	private ConstrutorGeradorDeEventos() {
		
	}

	public IEvento criarEventoAleatorio(int data){
		IEvento eventoAleatorio = geradorAleatorio.gerarEventoAleatorio(data);
		return eventoAleatorio;
	}

	public IEvento criarEventoConstrucao(IConstrucao construcao, int data){
		IEvento eventoConstrucao = geradorConstrucao.gerarEventoConstrucao(construcao, data);
		return eventoConstrucao;
	}
	
	public static IConstrutorGeradorDeEventos getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorGeradorDeEventos();
		}
		return instancia;
	}
}
