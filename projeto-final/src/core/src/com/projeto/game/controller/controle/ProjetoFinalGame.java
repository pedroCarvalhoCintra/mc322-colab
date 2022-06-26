package com.projeto.game.controller.controle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.projeto.game.controller.controle.ControleJogo;
import com.projeto.game.controller.controle.IControleJogo;
import com.projeto.game.view.cidade.IViewCidade;
import com.projeto.game.view.cidade.ViewCidade;
import com.projeto.game.view.populacao.IViewPopulacao;
import com.projeto.game.view.populacao.ViewPopulacao;

public class ProjetoFinalGame extends Game {
	
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	IControleJogo controle;
	
	IViewCidade viewCidade = new ViewCidade();
	IViewPopulacao viewPopulacao = new ViewPopulacao();
	
	public void create() {

		batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
		controle = ControleJogo.getInstancia();
		controle.criarAtores();
		
		viewCidade.connectCidade(controle.getCidade());
		viewPopulacao.connect(controle.getCidade().getPopulacao());

		setScreen(new MainMenuScreen(this));

		//Aqui � onde ocorre a instancia��o das variaveis globais, essencialmente.
		//Aqui vc chama o MainMenuScreen tamb�m.
	}
	
	public void dispose () {
		//Aqui voc� libera os assets na mem�ria. N�o � essencial, dependendo pode at� deletar.
    }
	
	public void resize () {
		//Eu monto isso depois, s� to botando pra n�o esquecer.
	}
	
}
