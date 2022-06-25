package com.projeto.game.model.construcao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Industria extends Construcao {
	final static private Texture TEX_INDUSTRIA = new Texture(Gdx.files.internal("Sprites/industry.png"));
	final static private Image IMG_INDUSTRIA = new Image(TEX_INDUSTRIA);
	
    public Industria(){
        super();
		this.satisfacao = 0;
		this.preco = 0;
		this.renda = 0;
    }

    public String getTipo(){
        return "Industria";
    }

    public Industria buildConstrucao(){
        return new Industria();
    }
    
    public Group criarConstrucaoVisual() {
		Group grupo = new Group();
		grupo.setName(String.valueOf(getLinha()) + String.valueOf(getColuna()));
		
		STYLE.imageOver = TEXREG_OVERLAY;
		
		ImageButton botao = new ImageButton(STYLE);
		
		botao.addListener(new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				 
			}
		});
		
		IMG_MOLDURA.setSize(90, 90);
		IMG_INDUSTRIA.setSize(80, 80);
		IMG_INDUSTRIA.setPosition(botao.getX()+5, botao.getY()+5);
		
		grupo.addActor(IMG_INDUSTRIA);
		grupo.addActor(IMG_MOLDURA);
		grupo.addActor(botao);
		
		return grupo;
	}
}
