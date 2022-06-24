package com.projeto.game.controller.construtor;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.projeto.game.model.calendario.ICalendario;
import com.projeto.game.model.cidade.Cidade;
import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.construcao.Escola;
import com.projeto.game.model.construcao.Hospital;
import com.projeto.game.model.construcao.IConstrucao;
import com.projeto.game.model.construcao.Industria;
import com.projeto.game.model.construcao.Mercado;
import com.projeto.game.model.construcao.Moradia;
import com.projeto.game.model.construcao.Prefeitura;
import com.projeto.game.model.construcao.Vazio;
import com.projeto.game.model.populacao.IPopulacao;
import com.projeto.game.model.populacao.Populacao;


public class FactoryConstrutor implements IFactoryConstrutor {

	private static IFactoryConstrutor instancia;
	final static private IBuildConstrucao construtorConstrucao = ConstrutorConstrucao.getInstancia();
	final static private IBuildPopulacao construtorPopulacao = ConstrutorPopulacao.getInstancia();
	final static private IBuildCidade construtorCidade = ConstrutorCidade.getInstancia();
	final static private IBuildBotao construtorBotao = ConstrutorBotao.getInstancia();
	final static private IBuildCalendario construtorCalendario = ConstrutorCalendario.getInstancia();
	
	private FactoryConstrutor(){

	}
	
	public ICidade criarCidade() {
		ICidade cidade = construtorCidade.buildCidade(construtorPopulacao, construtorConstrucao);
		
		
		return cidade;
	}
	
	public IConstrucao criarConstrucao(String tipo) {
		IConstrucao construcao;
		
		switch(tipo) {
			case "moradia":
				construcao = construtorConstrucao.buildMoradia();
				break;
			case "mercado":
				construcao = construtorConstrucao.buildMercado();
				break;
			case "industria":
				construcao = construtorConstrucao.buildIndustria();
				break;
			case "prefeitura":
				construcao = construtorConstrucao.buildPrefeitura();
				break;
			case "hospital":
				construcao = construtorConstrucao.buildHospital();
				break;
			case "escola":
				construcao = construtorConstrucao.buildEscola();
				break;
			default:
				construcao = construtorConstrucao.buildVazio();
				break;
		}
	
		return construcao;
	}
	
	public IPopulacao criarPopulacao() {
		IPopulacao populacao = construtorPopulacao.buildPopulacao();
		
		return populacao;
	}

	public Button criarBotao(String tipo) {
		
		return null;
	}

	public ICalendario criarCalendario() {
		ICalendario calendario = construtorCalendario.buildCalendario();
		
		return null;
	}
	



	public static IFactoryConstrutor getInstancia() {
		if (instancia == null) {
			instancia = new FactoryConstrutor();
		}
		return instancia;
	}
}
