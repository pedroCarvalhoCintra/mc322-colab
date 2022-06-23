package com.projeto.game.model.construcao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Moradia extends Construcao {
	private static Texture textura = new Texture(Gdx.files.internal("Sprites/frame.png"));
	private static Image icone = new Image(textura);
	
	
    public Moradia(){
        super();
    }

    public String getTipo(){
        return "Moradia";
    }

    public Moradia buildConstrucao(){
        return new Moradia();
    }

	public void criarConstrucaoVisual() {
		
	}
}
