package com.projeto.game.controller.construtor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ConstrutorBotao implements IBuildBotao{
	final static private Texture TEX_VAZIO = new Texture(Gdx.files.internal("Sprites/empty_90x90.png"));
	final static private Texture TEX_OVERLAY = new Texture(Gdx.files.internal("Sprites/whiteoverlay_90x90.png"));
	
	final static private TextureRegionDrawable TEXREG_VAZIO= new TextureRegionDrawable(TEX_VAZIO);
	final static private TextureRegionDrawable TEXREG_OVERLAY = new TextureRegionDrawable(TEX_OVERLAY);
	
	final static private ImageButtonStyle STYLE_BOTAO_IMAGEM =  new ImageButtonStyle(null, null, null, TEXREG_VAZIO, TEXREG_VAZIO, TEXREG_OVERLAY);

	final static private Skin SKIN = new Skin(Gdx.files.internal("Skin/uiskin.json"));
	
	
	private static IBuildBotao instancia;
	
	private ConstrutorBotao() {
		
	}
	
	public Button buildBotaoTexto() {
		TextButton botao = new TextButton(null, null);
	}

	public Button buildBotaoImagem() {
		ImageButton botao = new ImageButton(STYLE_BOTAO_IMAGEM);
		return null;
	} 
	
	public static IBuildBotao getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorBotao();
		}
		return instancia;
	}
}
