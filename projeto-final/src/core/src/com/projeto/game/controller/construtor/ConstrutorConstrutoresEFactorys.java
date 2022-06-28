package com.projeto.game.controller.construtor;

import com.projeto.game.controller.construtor.gerador.ConstrutorConstrutorGeradorDeEventos;
import com.projeto.game.controller.construtor.gerador.IConstrutorConstrutorGeradorDeEventos;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.controller.construtor.gui.FactoryGui;
import com.projeto.game.controller.construtor.calendario.IConstrutorCalendario;
import com.projeto.game.controller.construtor.calendario.ConstrutorCalendario;
import com.projeto.game.controller.construtor.cidade.IConstrutorCidade;
import com.projeto.game.controller.construtor.construcoes.FactoryConstrucao;
import com.projeto.game.controller.construtor.construcoes.IFactoryConstrucao;
import com.projeto.game.controller.construtor.cidade.ConstrutorCidade;
import com.projeto.game.controller.construtor.populacao.IConstrutorPopulacao;
import com.projeto.game.controller.construtor.populacao.ConstrutorPopulacao;


public class ConstrutorConstrutoresEFactorys implements IConstrutorConstrutoresEFactorys {

	private static IConstrutorConstrutoresEFactorys instancia;
	final static private IFactoryConstrucao FACTORY_CONSTRUCAO = FactoryConstrucao.getInstancia();
	final static private IConstrutorPopulacao CONSTRUTOR_POPULACAO = ConstrutorPopulacao.getInstancia();
	final static private IConstrutorCidade CONSTRUTOR_CIDADE = ConstrutorCidade.getInstancia();
	final static private IConstrutorCalendario CONSTRUTOR_CALENDARIO = ConstrutorCalendario.getInstancia();
	final static private IFactoryGui FACTORY_GUI = FactoryGui.getInstancia();
	final static private IConstrutorConstrutorGeradorDeEventos CONSTRUTOR_FACTORY_GERADOR_EVENTOS = ConstrutorConstrutorGeradorDeEventos.getInstancia();
	
	private ConstrutorConstrutoresEFactorys(){

	}
		
	public IConstrutorCidade criarConstrutorCidade() {
		return CONSTRUTOR_CIDADE;
	}
	
	public IFactoryConstrucao criarFactoryConstrucao() {
		return FACTORY_CONSTRUCAO;
	}
	
	public IFactoryGui criarFactoryGui() {
		return FACTORY_GUI;
	}

	public IConstrutorPopulacao criarConstrutorPopulacao() {
		return CONSTRUTOR_POPULACAO;
	}

	public IConstrutorCalendario criarConstrutorCalendario() {
		return CONSTRUTOR_CALENDARIO;
	}

	public IConstrutorConstrutorGeradorDeEventos criarFactoryGeradorDeEventos(){
		return CONSTRUTOR_FACTORY_GERADOR_EVENTOS;
	}

	public static IConstrutorConstrutoresEFactorys getInstancia() {
		if (instancia == null) {
			instancia = new ConstrutorConstrutoresEFactorys();
		}
		return instancia;
	}
}
