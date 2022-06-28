package com.projeto.game.controller.controle.subcontroles.cidade;

import com.projeto.game.controller.construtor.construcoes.IFactoryConstrucao;
import com.projeto.game.controller.controle.exception.ConstrucaoInvalida;
import com.projeto.game.controller.controle.exception.DinheiroInsuficiente;
import com.projeto.game.controller.controle.exception.PrefeituraInvalida;
import com.projeto.game.controller.controle.subcontroles.calendario.ISubControleCalendario;
import com.projeto.game.controller.controle.subcontroles.gui.ISubControleGui;
import com.projeto.game.controller.controle.subcontroles.visual.ISubControleVisual;
import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.construcao.IConstrucao;

public class SubControleCidade implements ISubControleCidade {
	private static ISubControleCidade instancia;
	private int prefeituraConstruida = 0;
	
    private IFactoryConstrucao factoryConstrucoes;
    private ISubControleCalendario subControleCalendario;
    private ISubControleGui subControleGui;
    private ISubControleVisual subControleVisual;
    private ICidade cidade;
	
	private SubControleCidade() {
		
	}
	
    public void construirConstrucao(String tipo, int linha, int coluna) {
    	IConstrucao novo;
		novo = factoryConstrucoes.criarConstrucao(tipo, linha, coluna);		
		try {
			cidade.adicionarConstrucao(novo);
			subControleCalendario.addEventoConstrucao(novo, prefeituraConstruida);
			
		} catch (DinheiroInsuficiente moneyProblem) {
			String texto = "You don't have enough money to build this!\nYou're missing $" + String.valueOf(novo.getPreco() - cidade.getDinheiro()) + "!";
    		subControleGui.adicionarDialogoExcecao(texto);
		}
		
		catch (PrefeituraInvalida tooMuchBureaucracy) {
			String texto = "You cannot build another Town Hall! A city can only have one Town Hall. \nThat's enough bureaucracy, right?";
    		subControleGui.adicionarDialogoExcecao(texto);

		}
		
		/*
		catch (Exception exception){
			String texto = "Some sort of unhandled exception has happened. That's sad.\nPlease send a report at the game's repository so we can get it fixed ASAP!\nThink of the good part: your game could've crashed!";
    		subControleGui.adicionarDialogoExcecao(texto);
		}
		*/
		
		finally {
			subControleVisual.atualizar();
		}
    }
    
    public void removerConstrucao(int linha, int coluna) {
    	IConstrucao novo;
		try {
			cidade.removerConstrucao(linha, coluna);
			novo = factoryConstrucoes.criarConstrucao("Vazio", linha, coluna);
			cidade.adicionarConstrucao(novo);
			
		} catch (ConstrucaoInvalida noCanDo) {
			String texto = "It seems our engineers found a problem as they were demolishing this building.\nMaybe it's haunted!";
    		subControleGui.adicionarDialogoExcecao(texto);	
		}
		
		finally {
			subControleVisual.atualizar();
		}
    }
	
	public static ISubControleCidade getInstancia() {
		if (instancia == null) {
			instancia = new SubControleCidade();
		}
		
		return instancia;
	}

	public void connectCidade(ICidade cidade) {
		this.cidade = cidade;
	}

	public void connectFactoryConstrucoes(IFactoryConstrucao factory) {
		this.factoryConstrucoes = factory;
	}

	public void connectSubControleCalendario(ISubControleCalendario subControleCalendario) {
		this.subControleCalendario = subControleCalendario;
	}

	public void connectSubControleGui(ISubControleGui subControleGui) {
		this.subControleGui = subControleGui;
	}

	public void connectSubControleVisual(ISubControleVisual subControleVisual) {
		this.subControleVisual = subControleVisual;
	}
}
