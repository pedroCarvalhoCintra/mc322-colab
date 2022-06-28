package com.projeto.game.controller.controle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.projeto.game.controller.construtor.gui.IFactoryGui;

public class MainMenuScreen extends ScreenAdapter { 
	final static private Texture TEX_BACKGROUND = new Texture(Gdx.files.internal("Sprites/titlescreen.png"));
	
	final private ProjetoFinalGame game;
	private IControleJogo controle;
	private IFactoryGui construtorGui;
	private Stage stage;
	private Image imagem = new Image(TEX_BACKGROUND); 

    public MainMenuScreen(ProjetoFinalGame game){
        this.game = game;
        this.controle = game.getControle();
        this.construtorGui = controle.getFactoryGui();
        this.stage = new Stage(new ExtendViewport(1920, 1080));
        imagem.setScale(4);
    }

    public void show(){
		Gdx.input.setInputProcessor(stage);
    	stage.addActor(imagem);
		criarBotaoTelaNome();
		criarTitulo();
		//controle.conectarVisuais(stage);
    }
    
    public void criarTitulo() {
    	Label titulo = construtorGui.criarLabel("Untitled\nCity\nGame", 5, "white");
    	titulo.setPosition(stage.getWidth()/2-300, stage.getHeight()/2);
    	stage.addActor(titulo);

    }
    
    public void criarBotaoTelaNome() {
    	Button botao = construtorGui.criarBotao("texto", "Play", 400, 150, 0, 0);
    	botao.setPosition(stage.getWidth()/2-100, stage.getHeight()/2-400);
    	
		ClickListener listenerClick = new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				game.setScreen(new GameScreen(game));
			}
		};
    	
		botao.addListener(listenerClick);
    	stage.addActor(botao);
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
