package com.projeto.game.model.construcao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Vazio extends Construcao {
	final static private Texture TEX_GRAMA_1= new Texture(Gdx.files.internal("Sprites/grass_1.png"));
	final static private Texture TEX_ARVORE_1 = new Texture(Gdx.files.internal("Sprites/tree_1.png"));
	
    public Vazio(){
        super();
		this.satisfacao = 0;
		this.preco = 0;
		this.renda = 0;
    }

    public String getTipo() {
        return "Vazio";
    }
    
    public int getTempoConstrucao() {
    	return 0;
    }
    
    public Vazio buildConstrucao() {
    	return new Vazio();
    }

	public Group criarConstrucaoVisual() {
		Group grupo = super.criarConstrucaoVisual();
		Image img_fundo = new Image(TEX_GRAMA_1);
		
		if (this.getColuna() == 8 && this.getLinha() == 6) {
				img_fundo = new Image(TEX_ARVORE_1);
		}
		
		else if (this.getColuna() == 2 && this.getLinha() == 3) {
			img_fundo = new Image(TEX_ARVORE_1);
		}
		
		else if (this.getColuna() == 8 && this.getLinha() == 1) {
			img_fundo = new Image(TEX_ARVORE_1);
		}
		
		else if (this.getColuna() == 3 && this.getLinha() == 7) {
			img_fundo = new Image(TEX_ARVORE_1);
		}
		
		else if (this.getColuna() == 2 && this.getLinha() == 8) {
			img_fundo = new Image(TEX_ARVORE_1);
		}
		
		img_fundo.setSize(80, 80);
		img_fundo.setPosition(botao.getX()+5, botao.getY()+5);
		
		grupo.addActorBefore(IMG_MOLDURA, img_fundo);
		return grupo;
	}
}
