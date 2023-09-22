package com.projeto.game.controller.controle.subcontroles.visual;

import com.projeto.game.view.calendario.IViewCalendario;
import com.projeto.game.view.cidade.IViewCidade;
import com.projeto.game.view.populacao.IViewPopulacao;

public interface IRConnectViews {
	public void connectViewCidade(IViewCidade viewCidade);
	public void connectViewPopulacao(IViewPopulacao viewPopulacao);
	public void connectViewCalendario(IViewCalendario viewCalendario);
}