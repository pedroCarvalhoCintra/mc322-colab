package com.projeto.game.model.construcao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Mercado extends Construcao {
	final static private Texture TEX_MERCADO = new Texture(Gdx.files.internal("Sprites/commercial.png"));
	final private Image IMG_MERCADO = new Image(TEX_MERCADO);
	
    public Mercado(){
        super();
		this.satisfacao = 0;
		this.preco = 0;
		this.renda = 0;
    }
    
    public String getTipo(){
        return "Mercado";
    }

    public Mercado buildConstrucao(){
        return new Mercado();
    }
    
    public Group criarConstrucaoVisual() {
		Group grupo = super.criarConstrucaoVisual();
		IMG_MERCADO.setSize(80, 80);
		IMG_MERCADO.setPosition(botao.getX()+5, botao.getY()+5);
		grupo.addActorBefore(IMG_MOLDURA, IMG_MERCADO);
		return grupo;
	}
}
