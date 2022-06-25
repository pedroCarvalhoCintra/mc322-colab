package com.projeto.game.model.construcao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Mercado extends Construcao {
	final static private Texture TEX_MERCADO = new Texture(Gdx.files.internal("Sprites/commercial.png"));
	final static private Image IMG_MERCADO = new Image(TEX_MERCADO);
	
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
		Group grupo = new Group();
		grupo.setName(String.valueOf(getLinha()) + String.valueOf(getColuna()));
		
		STYLE.imageOver = TEXREG_OVERLAY;
		
		ImageButton botao = new ImageButton(STYLE);
		
		botao.addListener(new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				 
			}
		});
		
		IMG_MOLDURA.setSize(90, 90);
		IMG_MERCADO.setSize(80, 80);
		IMG_MERCADO.setPosition(botao.getX()+5, botao.getY()+5);
		
		grupo.addActor(IMG_MERCADO);
		grupo.addActor(IMG_MOLDURA);
		grupo.addActor(botao);
		
		return grupo;
	}
}
