package com.projeto.game.controller.construtor;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.projeto.game.model.calendario.ICalendario;
import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.construcao.IConstrucao;
import com.projeto.game.model.populacao.IPopulacao;

public interface IFactoryConstrutor{
	public IPopulacao criarPopulacao();
	public IConstrucao criarConstrucao(String tipo);
	public ICidade criarCidade();
	public Button criarBotao(String tipo);
	public ICalendario criarCalendario();
	
}
