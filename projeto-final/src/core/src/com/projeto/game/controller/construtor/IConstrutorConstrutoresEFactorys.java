package com.projeto.game.controller.construtor;

import com.projeto.game.controller.construtor.gerador.IConstrutorFactoryGeradorDeEventos;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.controller.construtor.calendario.IConstrutorCalendario;
import com.projeto.game.controller.construtor.cidade.IConstrutorCidade;
import com.projeto.game.controller.construtor.populacao.IConstrutorPopulacao;
import com.projeto.game.controller.construtor.construcao.IFactoryConstrucao;

public interface IConstrutorConstrutoresEFactorys {
	public ICidade criarConstrutorCidade();
	public IConstrucao criarFactoryConstrucao();
	public IPopulacao criarConstrutorPopulacao();
	public IConstrutorCalendario criarConstrutorCalendario();
	public IConstrutorFactoryGeradorDeEventos criarFactoryGeradorDeEventos();
}