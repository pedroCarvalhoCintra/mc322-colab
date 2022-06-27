package com.projeto.game.controller.construtor.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.projeto.game.controller.controle.ControleJogo;
import com.projeto.game.controller.controle.IControleJogo;

public class ConstrutorBotao implements IBuildBotao{
	final static private Texture TEX_VAZIO = new Texture(Gdx.files.internal("Sprites/empty_90x90.png"));
	final static private Texture TEX_OVERLAY = new Texture(Gdx.files.internal("Sprites/whiteoverlay_90x90.png"));
	
	final static private TextureRegionDrawable TEXREG_VAZIO = new TextureRegionDrawable(TEX_VAZIO);
	final static private TextureRegionDrawable TEXREG_OVERLAY = new TextureRegionDrawable(TEX_OVERLAY);
	
	final static private ImageButtonStyle STYLE_BOTAO_IMAGEM_VAZIO =  new ImageButtonStyle(TEXREG_VAZIO, TEXREG_VAZIO, TEXREG_OVERLAY, TEXREG_VAZIO, TEXREG_VAZIO, TEXREG_OVERLAY);

	final static private Skin SKIN = new Skin(Gdx.files.internal("Skin/skin.json"));

	private static IBuildBotao instancia;
	private IControleJogo controle;
	
	private ConstrutorBotao() {
		
	}
	
	public Button buildBotaoTexto(String texto, float largura, float altura) {
		TextButton botao = new TextButton(texto, SKIN);
		botao.setSize(largura, altura);	
		return botao;
	}

	public Button buildBotaoImagemVazio(float largura, float altura) {
		if (STYLE_BOTAO_IMAGEM_VAZIO.imageOver == null) {
			STYLE_BOTAO_IMAGEM_VAZIO.imageOver = TEXREG_OVERLAY;
			STYLE_BOTAO_IMAGEM_VAZIO.over =  TEXREG_OVERLAY;
		}
		
		ImageButton botao = new ImageButton(STYLE_BOTAO_IMAGEM_VAZIO);
		botao.setSize(largura, altura);	
		return botao;
	}
	
	public Button buildBotaoImagem(TextureRegionDrawable image, float largura, float altura, final int linha, final int coluna, final String tipo) {
		ImageButtonStyle novoEstilo = new ImageButtonStyle(image, image, image, image, image, image);
		
		
		novoEstilo.imageOver = image;
		final ImageButton botao = new ImageButton(novoEstilo);
		
		
		ClickListener listenerClick = new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				controle.construirConstrucao(tipo, linha, coluna);
				botao.getParent().getParent().setVisible(false);
			}
		};
		
		
		botao.addListener(listenerClick);
		botao.setSize(largura, altura);	
		return botao;
	}
	
	public Button buildBotaoDestruir(String texto, float largura, float altura, final int linha, final int coluna, final String tipo) {
		final TextButton botao = new TextButton(texto, SKIN);
		botao.setSize(largura, altura);
		botao.getLabel().setFontScale(2);
		botao.setName("destruir");
		ClickListener listenerClick = new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				controle.removerConstrucao(linha, coluna);
				botao.getParent().setVisible(false);
			}
		};
		
		botao.addListener(listenerClick);
		return botao;
	}
	
	public void connect(ControleJogo controle) {
		this.controle = controle;
	}
	
	public static IBuildBotao getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorBotao();
		}
		return instancia;
	}
}