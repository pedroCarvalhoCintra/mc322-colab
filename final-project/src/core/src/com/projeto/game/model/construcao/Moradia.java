package com.projeto.game.model.construcao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Moradia extends Construcao {
	final static private Texture TEX_MORADIA = new Texture(Gdx.files.internal("Sprites/house_1.png"));
	final private Image IMG_MORADIA = new Image(TEX_MORADIA);
	
    public Moradia(){
        super();
		this.satisfacao = 1;
		this.preco = 150;
		this.renda = 0;
    }

    public String getTipo(){
        return "Household";
    }
    
    public int getTempoConstrucao() {
    	return 2;
    }

    public Moradia buildConstrucao(){
        return new Moradia();
    }

	public Group criarConstrucaoVisual() {
		Group grupo = super.criarConstrucaoVisual();

		if (this.construido == true) {
			IMG_MORADIA.setSize(80, 80);
			IMG_MORADIA.setPosition(botao.getX()+5, botao.getY()+5);
			grupo.addActorBefore(IMG_MOLDURA, IMG_MORADIA);
		}
		else {
			IMG_CONSTRUINDO.setSize(80, 80);
			IMG_CONSTRUINDO.setPosition(botao.getX()+5, botao.getY()+5);
			grupo.addActorBefore(IMG_MOLDURA, IMG_CONSTRUINDO);
		}
		return grupo;
	}
}
