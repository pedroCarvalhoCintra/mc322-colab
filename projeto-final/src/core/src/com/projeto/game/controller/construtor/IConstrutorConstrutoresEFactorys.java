package com.projeto.game.controller.construtor;

import com.projeto.game.controller.construtor.gerador.IConstrutorConstrutorGeradorDeEventos;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.controller.construtor.calendario.IConstrutorCalendario;
import com.projeto.game.controller.construtor.cidade.IConstrutorCidade;
import com.projeto.game.controller.construtor.construcoes.IFactoryConstrucao;
import com.projeto.game.controller.construtor.populacao.IConstrutorPopulacao;

public interface IConstrutorConstrutoresEFactorys {
	public IConstrutorCidade criarConstrutorCidade();
	public IFactoryConstrucao criarFactoryConstrucao();
	public IFactoryGui criarFactoryGui();
	public IConstrutorPopulacao criarConstrutorPopulacao();
	public IConstrutorCalendario criarConstrutorCalendario();
	public IConstrutorConstrutorGeradorDeEventos criarFactoryGeradorDeEventos();
}