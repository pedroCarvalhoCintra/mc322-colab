package com.projeto.game.model.construcao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Industria extends Construcao {
	final static private Texture TEX_INDUSTRIA = new Texture(Gdx.files.internal("Sprites/industry.png"));
	final private Image IMG_INDUSTRIA = new Image(TEX_INDUSTRIA);
	
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
		Group grupo = super.criarConstrucaoVisual();
		IMG_INDUSTRIA.setSize(80, 80);
		IMG_INDUSTRIA.setPosition(botao.getX()+5, botao.getY()+5);
		grupo.addActorBefore(IMG_MOLDURA, IMG_INDUSTRIA);
		return grupo;
	}
}
