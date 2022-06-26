package com.projeto.game.controller.construtor;

import com.projeto.game.controller.construtor.gerador.ConstrutorFactoryGeradorDeEventos;
import com.projeto.game.controller.construtor.gerador.IConstrutorFactoryGeradorDeEventos;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.controller.construtor.gui.FactoryGui;
import com.projeto.game.controller.construtor.calendario.IConstrutorCalendario;
import com.projeto.game.controller.construtor.calendario.ConstrutorCalendario;
import com.projeto.game.controller.construtor.cidade.IConstrutorCidade;
import com.projeto.game.controller.construtor.cidade.ConstrutorCidade;
import com.projeto.game.controller.construtor.populacao.IConstrutorPopulacao;
import com.projeto.game.controller.construtor.populacao.ConstrutorPopulacao;
import com.projeto.game.controller.construtor.construcao.IFactoryConstrucao;
import com.projeto.game.controller.construtor.construcao.FactoryConstrucao;

public class ConstrutorConstrutoresEFactorys implements IConstrutorConstrutoresEFactorys {

	private static IConstrutorConstrutoresEFactorys instancia;
	final static private IFactoryConstrucao FACTORY_CONSTRUCAO = FactoryConstrucao.getInstancia();
	final static private IConstrutorPopulacao CONSTRUTOR_POPULACAO = ConstrutorPopulacao.getInstancia();
	final static private IConstrutorCidade CONSTRUTOR_CIDADE = ConstrutorCidade.getInstancia();
	final static private IConstrutorCalendario CONSTRUTOR_CALENDARIO = ConstrutorCalendario.getInstancia();
	final static private IFactoryGui FACTORY_GUI = FactoryGui.getInstancia();
	final static private IConstrutorFactoryGeradorDeEventos CONSTRUTOR_FACTORY_GERADOR_EVENTOS = ConstrutorFactoryGeradorDeEventos.getInstancia();
	
	private ConstrutorConstrutoresEFactorys(){

	}
		
	public ICidade criarConstrutorCidade() {
		return this.CONSTRUTOR_CIDADE;
	}
	
	public IConstrucao criarFactoryConstrucao() {
		return this.FACTORY_CONSTRUCAO;
	}
	
	public IConstrucao criarFactoryGui() {
		return this.FACTORY_GUI;
	}

	public IPopulacao criarConstrutorPopulacao() {
		return this.CONSTRUTOR_POPULACAO;
	}

	public IConstrutorCalendario criarConstrutorCalendario() {
		return this.CONSTRUTOR_CALENDARIO;
	}

	public IConstrutorFactoryGeradorDeEventos criarFactoryGeradorDeEventos(){
		return this.CONSTRUTOR_FACTORY_GERADOR_EVENTOS;
	}

	public static IConstrutorConstrutoresEFactorys getInstancia() {
		if (instancia == null) {
			instancia = new FactoryConstrutor();
		}
		return instancia;
	}
}
