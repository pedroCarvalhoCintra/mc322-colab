package com.projeto.game.controller.controle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.projeto.game.controller.controle.ControleJogo;
import com.projeto.game.controller.controle.IControleJogo;

public class ProjetoFinalGame extends Game {
	
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	IControleJogo controle;

	//Aqui s�o definidas as vari�veis globais
		
	
	public void create() {

		batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
		controle = ControleJogo.getInstancia();

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
