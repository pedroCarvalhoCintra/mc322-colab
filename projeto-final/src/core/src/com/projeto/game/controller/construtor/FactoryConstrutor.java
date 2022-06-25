package com.projeto.game.controller.construtor;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.projeto.game.model.calendario.ICalendario;
import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.construcao.IConstrucao;
import com.projeto.game.model.populacao.IPopulacao;
package com.projeto.game.model.gerador.IFactoryGeradorDeEventos;

public class FactoryConstrutor implements IFactoryConstrutor {

	private static IFactoryConstrutor instancia;
	final static private IBuildConstrucao construtorConstrucao = ConstrutorConstrucao.getInstancia();
	final static private IBuildPopulacao construtorPopulacao = ConstrutorPopulacao.getInstancia();
	final static private IBuildCidade construtorCidade = ConstrutorCidade.getInstancia();
	final static private IBuildBotao construtorBotao = ConstrutorBotao.getInstancia();
	final static private IBuildCalendario construtorCalendario = ConstrutorCalendario.getInstancia();
	final static private IBuildGeradorDeEventos construtorGeradorDeEventos = ConstrutorGeradorDeEventos.getInstancia();

	private FactoryConstrutor(){

	}
	
	public ICidade criarCidade() {
		ICidade cidade = construtorCidade.buildCidade(construtorPopulacao, construtorConstrucao);
		return cidade;
	}
	
	public IConstrucao criarConstrucao(String tipo, int linha, int coluna) {
		IConstrucao construcao;
		
		switch (tipo) {
			case "moradia":
				construcao = construtorConstrucao.buildMoradia(linha,coluna);
				break;
			case "mercado":
				construcao = construtorConstrucao.buildMercado(linha,coluna);
				break;
			case "industria":
				construcao = construtorConstrucao.buildIndustria(linha,coluna);
				break;
			case "prefeitura":
				construcao = construtorConstrucao.buildPrefeitura(linha,coluna);
				break;
			case "hospital":
				construcao = construtorConstrucao.buildHospital(linha,coluna);
				break;
			case "escola":
				construcao = construtorConstrucao.buildEscola(linha,coluna);
				break;
			default:
				construcao = construtorConstrucao.buildVazio(linha,coluna);
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

	public IFactoryGeradorDeEventos criarGeradorDeEventos(){
		IFactoryGeradorDeEventos geradorDeEventos = construtorGeradorDeEventos.buildGeradorDeEventos();
		return geradorDeEventos;
	}

	public static IFactoryConstrutor getInstancia() {
		if (instancia == null) {
			instancia = new FactoryConstrutor();
		}
		return instancia;
	}
}
