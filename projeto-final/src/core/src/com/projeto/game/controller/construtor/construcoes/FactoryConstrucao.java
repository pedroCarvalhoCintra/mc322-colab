package com.projeto.game.controller.construtor.construcoes;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.model.construcao.IConstrucao;

public class FactoryConstrucao implements IFactoryConstrucao {
	final static private IBuildConstrucao CONSTRUTOR_CONSTRUCAO = ConstrutorConstrucao.getInstancia();
	final static private ButtonGroup<Button> GRUPO_BOTOES = new ButtonGroup<Button>();
	
	static private IFactoryConstrucao instancia;
	private IFactoryGui construtorGui;
	
	public IConstrucao criarConstrucao(String tipo, int linha, int coluna) {
		IConstrucao construcao;
		
		switch (tipo) {
			case "moradia":
				construcao = CONSTRUTOR_CONSTRUCAO.buildMoradia(linha,coluna);
				construcao.setJanela(construtorGui.criarJanela("texto", "Moradia", "" , 750, 350));
				break;
			case "mercado":
				construcao = CONSTRUTOR_CONSTRUCAO.buildMercado(linha,coluna);
				construcao.setJanela(construtorGui.criarJanela("texto", "Mercado", "" , 750, 350));
				break;
			case "industria":
				construcao = CONSTRUTOR_CONSTRUCAO.buildIndustria(linha,coluna);
				construcao.setJanela(construtorGui.criarJanela("texto", "Industria", "" , 750, 350));
				break;
			case "prefeitura":
				construcao = CONSTRUTOR_CONSTRUCAO.buildPrefeitura(linha,coluna);
				construcao.setJanela(construtorGui.criarJanela("texto", "Prefeitura", "" , 750, 350));
				break;
			case "hospital":
				construcao = CONSTRUTOR_CONSTRUCAO.buildHospital(linha,coluna);
				construcao.setJanela(construtorGui.criarJanela("texto", "Hospital", "" , 750, 350));
				break;
			case "escola":
				construcao = CONSTRUTOR_CONSTRUCAO.buildEscola(linha,coluna);
				construcao.setJanela(construtorGui.criarJanela("texto", "Escola", "" , 750, 350));
				break;
			default:
				construcao = CONSTRUTOR_CONSTRUCAO.buildVazio(linha,coluna);
				construcao.setJanela(construtorGui.criarJanela("construcao", "Escola o que gostaria de construir", "", 750, 350));
				break;
		}
		Button botao = construtorGui.criarBotao("vazio", "", 90, 90);
		
		GRUPO_BOTOES.add(botao);
		GRUPO_BOTOES.setMaxCheckCount(1);
		GRUPO_BOTOES.setMinCheckCount(0);
		
		construcao.setBotao(botao);
		
		return construcao;
	}
	
	public void connect(IFactoryGui fabrica) {
		this.construtorGui = fabrica;
	}
	
	static public IFactoryConstrucao getInstancia() {
		if (instancia == null) {
			instancia = new FactoryConstrucao();
		}
		return instancia;
	}
}
