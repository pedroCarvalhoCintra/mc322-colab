package com.projeto.game.controller.controle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.projeto.game.controller.construtor.IConstrutorConstrutoresEFactorys;
import com.projeto.game.controller.construtor.calendario.IConstrutorCalendario;
import com.projeto.game.controller.construtor.cidade.IConstrutorCidade;
import com.projeto.game.controller.construtor.construcoes.IFactoryConstrucao;
import com.projeto.game.controller.construtor.gerador.IConstrutorConstrutorGeradorDeEventos;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.controller.construtor.populacao.IConstrutorPopulacao;
import com.projeto.game.model.calendario.ICalendario;
import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.gerador.IConstrutorGeradorDeEventos;
import com.projeto.game.view.cidade.IViewCidade;
import com.projeto.game.view.cidade.ViewCidade;
import com.projeto.game.view.populacao.IViewPopulacao;
import com.projeto.game.view.populacao.ViewPopulacao;

public class ProjetoFinalGame extends Game {
	
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	IControleJogo controle;

    IConstrutorConstrutoresEFactorys construtorGeral;
    IConstrutorCalendario construtorCalendario;
    IConstrutorCidade construtorCidade;
    IFactoryConstrucao factoryConstrucoes;
    IFactoryGui construtorGui;
    IConstrutorPopulacao construtorPopulacao;
    IConstrutorGeradorDeEventos ConstrutorGeradorDeEventos;
    ICidade cidade;
    ICalendario calendario;
    IConstrutorConstrutorGeradorDeEventos ConstrutorFactoryGeradorDeEventos;
	
	public void create() {

		batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
		controle = ControleJogo.getInstancia();
		controle.criarAtores();

		setScreen(new MainMenuScreen(this));
	}
	
	public void dispose () {
    }
	
	public void resize () {
	}
	
	public IControleJogo getControle() {
		return this.controle;
	}
	
}
