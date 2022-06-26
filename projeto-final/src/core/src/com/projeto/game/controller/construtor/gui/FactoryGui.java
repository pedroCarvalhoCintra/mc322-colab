package com.projeto.game.controller.construtor.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class FactoryGui implements IFactoryGui {
	static private IFactoryGui instancia;
	
	final static private IBuildBotao CONSTRUTOR_BOTAO = ConstrutorBotao.getInstancia();
	final static private IBuildJanela CONSTRUTOR_JANELA = ConstrutorJanela.getInstancia();
	final static private IBuildLabel CONSTRUTOR_LABEL = ConstrutorLabel.getInstancia();
	
	final static private Texture TEX_ICONE_MORADIA = new Texture(Gdx.files.internal("Sprites/icon_house.png"));
	final static private Texture TEX_ICONE_ESCOLA = new Texture(Gdx.files.internal("Sprites/icon_school.png"));
	final static private Texture TEX_ICONE_HOSPITAL = new Texture(Gdx.files.internal("Sprites/icon_hospital.png"));
	final static private Texture TEX_ICONE_INDUSTRIA = new Texture(Gdx.files.internal("Sprites/icon_industry.png"));
	final static private Texture TEX_ICONE_MERCADO = new Texture(Gdx.files.internal("Sprites/icon_commercial.png"));
	final static private Texture TEX_ICONE_PREFEITURA = new Texture(Gdx.files.internal("Sprites/icon_towncenter.png"));
	
	final static private TextureRegionDrawable TEXREG_MORADIA = new TextureRegionDrawable(TEX_ICONE_MORADIA);
	final static private TextureRegionDrawable TEXREG_ESCOLA = new TextureRegionDrawable(TEX_ICONE_ESCOLA);
	final static private TextureRegionDrawable TEXREG_HOSPITAL = new TextureRegionDrawable(TEX_ICONE_HOSPITAL);
	final static private TextureRegionDrawable TEXREG_INDUSTRIA = new TextureRegionDrawable(TEX_ICONE_INDUSTRIA);
	final static private TextureRegionDrawable TEXREG_MERCADO = new TextureRegionDrawable(TEX_ICONE_MERCADO);
	final static private TextureRegionDrawable TEXREG_PREFEITURA = new TextureRegionDrawable(TEX_ICONE_PREFEITURA);
	
	private FactoryGui() {
		
	}
	
	public Button criarBotao(String tipo, String texto, float largura, float altura) {
		Button botao;
		switch (tipo) {
		case "texto":
			botao = CONSTRUTOR_BOTAO.buildBotaoTexto(texto, largura, altura);
			break;
		case "vazio":
			botao = CONSTRUTOR_BOTAO.buildBotaoImagemVazio(largura, altura);
			break;
		case "icone_moradia":
			botao = CONSTRUTOR_BOTAO.buildBotaoImagem(TEXREG_MORADIA, largura, altura);
			break;
		case "icone_escola":
			botao = CONSTRUTOR_BOTAO.buildBotaoImagem(TEXREG_ESCOLA, largura, altura);
			break;
		case "icone_hospital":
			botao = CONSTRUTOR_BOTAO.buildBotaoImagem(TEXREG_HOSPITAL, largura, altura);
			break;
		case "icone_industria":
			botao = CONSTRUTOR_BOTAO.buildBotaoImagem(TEXREG_INDUSTRIA, largura, altura);
			break;
		case "icone_mercado":
			botao = CONSTRUTOR_BOTAO.buildBotaoImagem(TEXREG_MERCADO, largura, altura);
			break;
		case "icone_prefeitura":
			botao = CONSTRUTOR_BOTAO.buildBotaoImagem(TEXREG_PREFEITURA, largura, altura);
			break;
		default:
			botao = null;
			break;
		}
		return botao;
	}
	
	public Window criarJanela(String tipo, String titulo, String texto, float largura, float altura) {
		Window janela;
		
		String[] icones = {"icone_moradia", "icone_escola", "icone_hospital", "icone_industria", "icone_mercado", "icone_prefeitura"};
		
		switch (tipo) {
			case "texto":
				janela = CONSTRUTOR_JANELA.buildJanela(titulo, largura, altura);
				janela.add(criarLabel(texto, 1)).expand();
				break;
			case "construcao":
				//Nesse caso, o texto de input eh passado para o label, e nao para o botao.
				janela = CONSTRUTOR_JANELA.buildJanela(titulo, largura, altura);
				for (String icone : icones) {
					Group grupo = new Group();
					Button botao = criarBotao(icone, null, 90, 90);
					Label label = criarLabel(texto, 1);
					
					label.setPosition(botao.getX(), botao.getY()-25);
					
					grupo.addActor(botao);
					grupo.addActor(label);
					janela.add(grupo).expand();
				}
				
				break;
			default:
				janela = null;
		}
		return janela;
	}
	
	public Label criarLabel(String texto, float tamanhoFonte) {
		//Tamanho da fonte eh em inteiro. 1 = tamanho normal, 0.5 = metade, 2 = dobro, etc.
		Label label = CONSTRUTOR_LABEL.criarLabel(texto, tamanhoFonte);
		return label;
	}
	
	static public IFactoryGui getInstancia() {
		if (instancia == null) {
			instancia = new FactoryGui();
		}
		return instancia;
	}
}
