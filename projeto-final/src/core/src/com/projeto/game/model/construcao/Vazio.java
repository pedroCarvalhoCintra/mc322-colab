package com.projeto.game.model.construcao;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Vazio extends Construcao {
	final static private Texture TEX_GRAMA_1= new Texture(Gdx.files.internal("Sprites/grass_1.png"));
	final static private Texture TEX_GRAMA_2 = new Texture(Gdx.files.internal("Sprites/grass_2.png"));
	final static private Texture TEX_ARVORE_1 = new Texture(Gdx.files.internal("Sprites/tree_1.png"));

	final static private Image IMG_GRAMA_1= new Image(TEX_GRAMA_1);
	final static private Image IMG_GRAMA_2= new Image(TEX_GRAMA_2);
	final static private Image IMG_ARVORE_1= new Image(TEX_ARVORE_1);

	
    public Vazio(){
        super();
		this.satisfacao = 0;
		this.preco = 0;
		this.renda = 0;
    }

    public String getTipo() {
        return "Vazio";
    }
    
    public Vazio buildConstrucao() {
    	return new Vazio();
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
		
		Image img_fundo;
		
		Random rand = new Random();
		int valor = rand.nextInt(100) + 1;
		
		if (valor <= 60) {
			img_fundo = IMG_GRAMA_1;
		}
		
		else if (valor > 60 && valor <= 80) {
			img_fundo = IMG_GRAMA_2;
		}
		
		else {
			img_fundo = IMG_ARVORE_1;
		}
		
		IMG_MOLDURA.setSize(90, 90);
		img_fundo.setSize(80, 80);
		img_fundo.setPosition(botao.getX()+5, botao.getY()+5);
		
		grupo.addActor(img_fundo);
		grupo.addActor(IMG_MOLDURA);
		grupo.addActor(botao);
		
		return grupo;
	}
}
