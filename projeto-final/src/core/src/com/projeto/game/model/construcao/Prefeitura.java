package com.projeto.game.model.construcao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Prefeitura extends Construcao {
	final static private Texture TEX_PREFEITURA = new Texture(Gdx.files.internal("Sprites/towncenter.png"));
	final private Image IMG_PREFEITURA = new Image(TEX_PREFEITURA);
	
    public Prefeitura(){
        super();
		this.satisfacao = 0;
		this.preco = 0;
		this.renda = 0;
    }

    public String getTipo(){
        return "Prefeitura";
    }

    public Prefeitura buildConstrucao(){
        return new Prefeitura();
    }
    
    public Group criarConstrucaoVisual() {
		Group grupo = super.criarConstrucaoVisual();
		IMG_PREFEITURA.setSize(80, 80);
		IMG_PREFEITURA.setPosition(botao.getX()+5, botao.getY()+5);
		grupo.addActorBefore(IMG_MOLDURA, IMG_PREFEITURA);
		return grupo;
	}
}
