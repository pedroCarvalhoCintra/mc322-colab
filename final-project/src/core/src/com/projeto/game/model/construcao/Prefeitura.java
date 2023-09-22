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
		this.preco = 5000;
		this.renda = -25;
    }

    public String getTipo(){
        return "Town Hall";
    }
    
    public int getTempoConstrucao() {
    	return 10;
    }

    public Prefeitura buildConstrucao(){
        return new Prefeitura();
    }
    
    public Group criarConstrucaoVisual() {
		Group grupo = super.criarConstrucaoVisual();
		
		if (this.construido == true) {
			IMG_PREFEITURA.setSize(80, 80);
			IMG_PREFEITURA.setPosition(botao.getX()+5, botao.getY()+5);
			grupo.addActorBefore(IMG_MOLDURA, IMG_PREFEITURA);
		}
		else {
			IMG_CONSTRUINDO.setSize(80, 80);
			IMG_CONSTRUINDO.setPosition(botao.getX()+5, botao.getY()+5);
			grupo.addActorBefore(IMG_MOLDURA, IMG_CONSTRUINDO);
		}
		return grupo;
	}
}
