package com.projeto.game.model.construcao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Hospital extends Construcao {
	final static private Texture TEX_HOSPITAL = new Texture(Gdx.files.internal("Sprites/hospital_1.png"));
	final private Image IMG_HOSPITAL = new Image(TEX_HOSPITAL);
	
    public Hospital(){
        super();
		this.satisfacao = 10;
		this.preco = 350;
		this.renda = -25;
    }

    public String getTipo(){
        return "Hospital";
    }

    public Hospital buildConstrucao(){
        return new Hospital();
    }
    
	public Group criarConstrucaoVisual() {
		Group grupo = super.criarConstrucaoVisual();
		
		if (this.construido == true) {
			IMG_HOSPITAL.setSize(80, 80);
			IMG_HOSPITAL.setPosition(botao.getX()+5, botao.getY()+5);
			grupo.addActorBefore(IMG_MOLDURA, IMG_HOSPITAL);
		}
		
		else {
			IMG_CONSTRUINDO.setSize(80, 80);
			IMG_CONSTRUINDO.setPosition(botao.getX()+5, botao.getY()+5);
			grupo.addActorBefore(IMG_MOLDURA, IMG_CONSTRUINDO);
		}
		return grupo;
	}
}
