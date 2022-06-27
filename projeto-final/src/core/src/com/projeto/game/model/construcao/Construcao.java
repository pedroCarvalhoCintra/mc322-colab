package com.projeto.game.model.construcao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public abstract class Construcao implements IConstrucao {
	final static private Texture TEX_VAZIO = new Texture(Gdx.files.internal("Sprites/empty_90x90.png"));
	final static private Texture TEX_OVERLAY = new Texture(Gdx.files.internal("Sprites/whiteoverlay_90x90.png"));
	final static private Texture TEX_MOLDURA= new Texture(Gdx.files.internal("Sprites/frame.png"));
	
	final protected Image IMG_MOLDURA = new Image(TEX_MOLDURA);
	
	final protected TextureRegionDrawable TEXREG_VAZIO= new TextureRegionDrawable(TEX_VAZIO);
	final protected TextureRegionDrawable TEXREG_OVERLAY = new TextureRegionDrawable(TEX_OVERLAY);

	final protected ImageButtonStyle STYLE =  new ImageButtonStyle(null, null, null, TEXREG_VAZIO, TEXREG_VAZIO, TEXREG_OVERLAY);
	
	protected Button botao;
	protected Window janela;
	
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
        return this.coluna;
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
	
    public Button getBotao() {
    	return this.botao;
    }
    
    public Window getJanela() {
    	return this.janela;
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
	
    public void setBotao(Button botao) {
    	this.botao = botao;
    }
    
    public void setJanela(Window janela) {
    	this.janela = janela;
    }

	public Group criarConstrucaoVisual() {
		Group grupo = new Group();
		grupo.setName(String.valueOf(getLinha()) + String.valueOf(getColuna()));

		ClickListener listenerClick = new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				if (botao.isChecked() == false) {
					janela.setVisible(false);
				}
				
				else {
					janela.setVisible(true);
				}
			}
		};
		
		ChangeListener listenerChange = new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				if (botao.isChecked() == false) {
					janela.setVisible(false);
				}
			}
		};
		
		this.botao.addListener(listenerClick);
		this.botao.addListener(listenerChange);
		
		IMG_MOLDURA.setSize(90, 90);
		grupo.addActor(IMG_MOLDURA);
		grupo.addActor(botao);
		return grupo;
	}
	
    public abstract String getTipo();
}
