package com.projeto.game.controller.construtor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.projeto.game.controller.construtor.calendario.ConstrutorCalendario;
import com.projeto.game.controller.construtor.calendario.IBuildCalendario;
import com.projeto.game.controller.construtor.cidade.ConstrutorCidade;
import com.projeto.game.controller.construtor.cidade.IBuildCidade;
import com.projeto.game.controller.construtor.construcoes.ConstrutorConstrucao;
import com.projeto.game.controller.construtor.construcoes.IBuildConstrucao;
import com.projeto.game.controller.construtor.gerador.ConstrutorGeradorDeEventos;
import com.projeto.game.controller.construtor.gerador.IBuildGeradorDeEventos;
import com.projeto.game.controller.construtor.gui.ConstrutorBotao;
import com.projeto.game.controller.construtor.gui.ConstrutorJanela;
import com.projeto.game.controller.construtor.gui.ConstrutorLabel;
import com.projeto.game.controller.construtor.gui.IBuildBotao;
import com.projeto.game.controller.construtor.gui.IBuildJanela;
import com.projeto.game.controller.construtor.gui.IBuildLabel;
import com.projeto.game.controller.construtor.populacao.ConstrutorPopulacao;
import com.projeto.game.controller.construtor.populacao.IBuildPopulacao;
import com.projeto.game.model.calendario.ICalendario;
import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.construcao.IConstrucao;
import com.projeto.game.model.populacao.IPopulacao;
import com.projeto.game.model.gerador.IFactoryGeradorDeEventos;

public class FactoryConstrutor implements IFactoryConstrutor {

	private static IFactoryConstrutor instancia;
	final static private IBuildConstrucao CONSTRUTOR_CONSTRUCAO = ConstrutorConstrucao.getInstancia();
	final static private IBuildPopulacao CONSTRUTOR_POPULACAO = ConstrutorPopulacao.getInstancia();
	final static private IBuildCidade CONSTRUTOR_CIDADE = ConstrutorCidade.getInstancia();
	final static private IBuildBotao CONSTRUTOR_BOTAO = ConstrutorBotao.getInstancia();
	final static private IBuildJanela CONSTRUTOR_JANELA = ConstrutorJanela.getInstancia();
	final static private IBuildLabel CONSTRUTOR_LABEL = ConstrutorLabel.getInstancia();
	final static private IBuildCalendario CONSTRUTOR_CALENDARIO = ConstrutorCalendario.getInstancia();
	final static private IBuildGeradorDeEventos CONSTRUTOR_GERADOR_EVENTOS = ConstrutorGeradorDeEventos.getInstancia();
	
	private FactoryConstrutor(){

	}
	
	public ICidade criarCidade() {
		ICidade cidade = CONSTRUTOR_CIDADE.buildCidade();
		return cidade;
	}
	
	public IConstrucao criarConstrucao(String tipo, int linha, int coluna) {
		IConstrucao construcao;
		
		switch (tipo) {
			case "moradia":
				construcao = CONSTRUTOR_CONSTRUCAO.buildMoradia(linha,coluna);
				construcao.setJanela(null);
				break;
			case "mercado":
				construcao = CONSTRUTOR_CONSTRUCAO.buildMercado(linha,coluna);
				construcao.setJanela(null);
				break;
			case "industria":
				construcao = CONSTRUTOR_CONSTRUCAO.buildIndustria(linha,coluna);
				construcao.setJanela(null);
				break;
			case "prefeitura":
				construcao = CONSTRUTOR_CONSTRUCAO.buildPrefeitura(linha,coluna);
				construcao.setJanela(null);
				break;
			case "hospital":
				construcao = CONSTRUTOR_CONSTRUCAO.buildHospital(linha,coluna);
				construcao.setJanela(null);
				break;
			case "escola":
				construcao = CONSTRUTOR_CONSTRUCAO.buildEscola(linha,coluna);
				construcao.setJanela(null);
				break;
			default:
				construcao = CONSTRUTOR_CONSTRUCAO.buildVazio(linha,coluna);
				construcao.setJanela(null);
				break;
		}
		construcao.setBotao(criarBotao("vazio", null, 90, 90));
		
		return construcao;
	}
	
	public IPopulacao criarPopulacao() {
		IPopulacao populacao = CONSTRUTOR_POPULACAO.buildPopulacao();
		return populacao;
	}

	public Button criarBotao(String tipo, String texto, float largura, float altura) {
		Button botao;
		switch (tipo) {
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

	public ICalendario criarCalendario() {
		ICalendario calendario = CONSTRUTOR_CALENDARIO.buildCalendario();
		return calendario;
	}

	public IFactoryGeradorDeEventos criarGeradorDeEventos(){
		IFactoryGeradorDeEventos geradorDeEventos = CONSTRUTOR_GERADOR_EVENTOS.buildGeradorDeEventos();
		return geradorDeEventos;
	}

	public static IFactoryConstrutor getInstancia() {
		if (instancia == null) {
			instancia = new FactoryConstrutor();
		}
		return instancia;
	}
}
