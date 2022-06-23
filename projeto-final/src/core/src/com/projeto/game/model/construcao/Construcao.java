package com.projeto.game.model.construcao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public abstract class Construcao implements IConstrucao {
	final static private Texture TEX_VAZIO = new Texture(Gdx.files.internal("Sprites/empty_90x90.png"));
	final static private Texture TEX_OVERLAY = new Texture(Gdx.files.internal("Sprites/whiteoverlay_90x90.png"));
	final static private Texture TEX_MOLDURA= new Texture(Gdx.files.internal("Sprites/frame.png"));
	
	final static protected Image IMG_MOLDURA = new Image(TEX_MOLDURA);
	
	final static protected TextureRegionDrawable TEXREG_VAZIO= new TextureRegionDrawable(TEX_VAZIO);
	final static protected TextureRegionDrawable TEXREG_OVERLAY = new TextureRegionDrawable(TEX_OVERLAY);

	final static protected ImageButtonStyle STYLE =  new ImageButtonStyle(null, null, null, TEXREG_VAZIO, TEXREG_VAZIO, TEXREG_OVERLAY);
	
	protected int linha;
    protected int coluna;
    protected int satisfacao;
    protected float preco;
    protected float renda;
    protected boolean construido;
    
    public Construcao (){
    }

    public int getLinha(){
        return this.linha;
    }

    public int getColuna(){
        return this.linha;
    }
    
    public int getSatisfacao() {
    	return this.satisfacao;
    }

    public float getPreco() {
		return this.preco;
	}

	public float getRenda() {
		return this.renda;
	}
	
	public boolean getConstruido() {
		return this.construido;
	}

	public void setLinha(int linha){
        this.linha = linha;
    }

    public void setColuna(int coluna){
        this.coluna = coluna;
    }

    public void setSatisfacao(int satisfacao) {
		this.satisfacao = satisfacao;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setRenda(float renda) {
		this.renda = renda;
	}
	
	public void setConstruido(boolean estado) {
		this.construido = estado;
	}

	public abstract Construcao buildConstrucao();
	public abstract Group criarConstrucaoVisual();
    public abstract String getTipo();
}
