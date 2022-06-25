package com.projeto.game.controller.controle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class MainMenuScreen extends ScreenAdapter { 

	private ProjetoFinalGame game;

    public MainMenuScreen(ProjetoFinalGame game){
        this.game = game;
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    game.controle.criarAtores();
                    game.setScreen(new GameScreen(game));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }

}
