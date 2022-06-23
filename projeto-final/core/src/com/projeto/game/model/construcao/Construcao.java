package com.projeto.game.model.construcao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class Construcao implements IConstrucao {
	static protected Texture tex_vazio = new Texture(Gdx.files.internal("Sprites/empty_90x90.png"));
	static protected Texture tex_overlay = new Texture(Gdx.files.internal("Sprites/whiteoverlay_90x90.png"));
	static protected Texture tex_moldura = new Texture(Gdx.files.internal("Sprites/frame.png"));
	
	static protected Image img_vazio = new Image(tex_vazio);
	static protected Image img_overlay = new Image(tex_overlay);
	static protected Image img_moldura = new Image(tex_moldura);


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
	public abstract void criarConstrucaoVisual();
    public abstract String getTipo();
}
