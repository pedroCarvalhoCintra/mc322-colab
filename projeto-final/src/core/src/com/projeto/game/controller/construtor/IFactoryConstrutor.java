package com.projeto.game.controller.construtor;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.projeto.game.model.calendario.ICalendario;
import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.construcao.IConstrucao;
import com.projeto.game.model.populacao.IPopulacao;
import com.projeto.game.model.gerador.IFactoryGeradorDeEventos;

public interface IFactoryConstrutor{
	public IPopulacao criarPopulacao();
	public IConstrucao criarConstrucao(String tipo, int linha, int coluna);
	public ICidade criarCidade();
	public Button criarBotao(String tipo, String texto, float largura, float altura);
	public Window criarJanela(String tipo, String titulo, String texto, float largura, float altura);
	public Label criarLabel(String texto, float tamanhoFonte);
	public ICalendario criarCalendario();
	public IFactoryGeradorDeEventos criarGeradorDeEventos();
}