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
	private Stage stage;

    public MainMenuScreen(ProjetoFinalGame game){
        this.game = game;
        this.stage = new Stage(new ExtendViewport(1920, 1080));
    }

    public void show(){
    	Table a = game.viewCidade.getVisual(stage);
    	a.debug();
    	stage.addActor(a);
    	
    }

    public void render(float delta) {
    	ScreenUtils.clear(0.278f, 0.176f, 0.235f, 1);
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
