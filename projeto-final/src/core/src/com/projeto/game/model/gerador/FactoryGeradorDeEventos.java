package com.projeto.game.model.gerador;

import com.projeto.game.model.evento.IEvento;
import com.projeto.game.model.construcao.IConstrucao;

public class FactoryGeradorDeEventos implements IFactoryGeradorDeEventos {
	
	private static IFactoryGeradorDeEventos instancia;
	final static private IGerarEventoAleatorio geradorAleatorio = GeradorEventoAleatorio.getInstancia();
	final static private IGerarEventoConstrucao geradorConstrucao = GeradorEventoConstrucao.getInstancia();

	
	private FactoryGeradorDeEventos() {
		
	}

	public IEvento criarEventoAleatorio(int data){
		IEvento eventoAleatorio = geradorAleatorio.gerarEventoAleatorio(data);
		return eventoAleatorio;
	}

	public IEvento criarEventoConstrucao(IConstrucao construcao, int data){
		IEvento eventoConstrucao = geradorConstrucao.gerarEventoConstrucao(construcao, data);
		return eventoConstrucao;
	}


	
	public static IFactoryGeradorDeEventos getInstancia() {
		if ( instancia == null ) {
			instancia = new FactoryGeradorDeEventos();
		}
		return instancia;
	}
}
