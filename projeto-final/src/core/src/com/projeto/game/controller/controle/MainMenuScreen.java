package com.projeto.game.controller.controle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class MainMenuScreen extends ScreenAdapter { 

	private ProjetoFinalGame game;
	private IControleJogo controle;
	private Stage stage;

    public MainMenuScreen(ProjetoFinalGame game){
        this.game = game;
        this.controle = game.getControle();
        this.stage = new Stage(new ExtendViewport(1920, 1080));
    }

    public void show(){
		Gdx.input.setInputProcessor(stage);

		controle.conectarVisuais(stage);
		
    	
    	stage.setDebugAll(true);
    	
    }

    public void render(float delta) {
    	ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1);

		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
    }

    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
    
    public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
    }

}
