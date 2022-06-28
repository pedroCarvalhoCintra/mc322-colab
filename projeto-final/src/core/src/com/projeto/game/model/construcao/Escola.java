package com.projeto.game.model.construcao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Escola extends Construcao {
	final static private Texture TEX_ESCOLA = new Texture(Gdx.files.internal("Sprites/school_1.png"));
	final private Image IMG_ESCOLA = new Image(TEX_ESCOLA);
	
    public Escola(){
        super();
		this.satisfacao = 5;
		this.preco = 200;
		this.renda = -5;
    }

    public String getTipo(){
        return "School";
    }
    
    public int getTempoConstrucao() {
    	return 5;
    }

    public Escola buildConstrucao(){
        return new Escola();
    }
    
	public Group criarConstrucaoVisual() {
		Group grupo = super.criarConstrucaoVisual();

		if (this.construido == true) {
			IMG_ESCOLA.setSize(80, 80);
			IMG_ESCOLA.setPosition(botao.getX()+5, botao.getY()+5);
			grupo.addActorBefore(IMG_MOLDURA, IMG_ESCOLA);
		}
		else {
			IMG_CONSTRUINDO.setSize(80, 80);
			IMG_CONSTRUINDO.setPosition(botao.getX()+5, botao.getY()+5);
			grupo.addActorBefore(IMG_MOLDURA, IMG_CONSTRUINDO);
		}
		return grupo;
	}
}
