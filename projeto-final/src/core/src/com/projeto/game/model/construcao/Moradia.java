package com.projeto.game.model.construcao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Moradia extends Construcao {
	final static private Texture TEX_MORADIA = new Texture(Gdx.files.internal("Sprites/house_1.png"));
	final static private Image IMG_MORADIA = new Image(TEX_MORADIA);
	
    public Moradia(){
        super();
		this.satisfacao = 0;
		this.preco = 0;
		this.renda = 0;
    }

    public String getTipo(){
        return "Moradia";
    }

    public Moradia buildConstrucao(){
        return new Moradia();
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
		IMG_MORADIA.setSize(80, 80);
		IMG_MORADIA.setPosition(botao.getX()+5, botao.getY()+5);
		
		grupo.addActor(IMG_MORADIA);
		grupo.addActor(IMG_MOLDURA);
		grupo.addActor(botao);
		
		return grupo;
	}
}
