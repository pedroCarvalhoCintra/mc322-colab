package com.projeto.game.controller.controle.subcontroles.visual;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.controller.controle.subcontroles.gui.ISubControleGui;
import com.projeto.game.view.calendario.IViewCalendario;
import com.projeto.game.view.cidade.IViewCidade;
import com.projeto.game.view.populacao.IViewPopulacao;

public class SubControleVisuais implements ISubControleVisual {
	static private SubControleVisuais instancia;
	
	private Stage stage;
	
	private IFactoryGui construtorGui;
	private ISubControleGui subControleGui;
	
	private IViewCidade viewCidade;
	private IViewPopulacao viewPopulacao;
	private IViewCalendario viewCalendario;
	
	private Group layoutCidade = new Group();
	private Group layoutSatisfacao = new Group();
	private Group layoutCalendario = new Group();
	private Group layoutDinheiro = new Group();
	private Group layoutNPopulacao = new Group();
	private Group layoutBotaoPassarDia = new Group();
	
	private SubControleVisuais() {
		
	}
	
	public void criarGruposVisuais() {
    	layoutCidade.addActor(viewCidade.getVisual(stage, construtorGui));
    	layoutSatisfacao.addActor(viewPopulacao.getVisualSatisfacao());
    	layoutCalendario.addActor(viewCalendario.getVisual());
    	layoutNPopulacao.addActor(viewPopulacao.getVisualNumPopulacao());
    	layoutDinheiro.addActor(viewCidade.getDinheiroVisual());
    	layoutBotaoPassarDia.addActor(subControleGui.adicionarBotaoPassarDia());
	}
	
    public void conectarVisuais() {    	
    	definirPosicoes();
    	
    	stage.addActor(layoutCidade);
    	stage.addActor(layoutSatisfacao);
    	stage.addActor(layoutCalendario);
    	stage.addActor(layoutNPopulacao);
    	stage.addActor(layoutDinheiro);
    	stage.addActor(layoutBotaoPassarDia);
    }
    
    public void definirPosicoes() {
    	layoutCidade.setPosition(45, 45);
    	layoutSatisfacao.setPosition(stage.getWidth()-400, stage.getHeight()/2 + 150);
    	layoutCalendario.setPosition(stage.getWidth()-400, stage.getHeight()/2 + 300);
    	layoutNPopulacao.setPosition(stage.getWidth()-850, stage.getHeight()/2 + 300);
    	layoutDinheiro.setPosition(stage.getWidth()-850, stage.getHeight()/2 + 150);
    	layoutBotaoPassarDia.setPosition(stage.getWidth()-400, stage.getHeight()/2+30);
    }
    
    public void connectViewCidade(IViewCidade viewCidade) {
    	this.viewCidade = viewCidade;
    }
    
    public void connectViewPopulacao(IViewPopulacao viewPopulacao) {
    	this.viewPopulacao = viewPopulacao;
    }
    
    public void connectViewCalendario(IViewCalendario viewCalendario) {
    	this.viewCalendario = viewCalendario;
    }
    
    public void connectStage(Stage stage) {
    	this.stage = stage;
    }
    
    public void atualizar() {
    	atualizarVisualPopulacao();
    	atualizarVisualCalendario();
    	atualizarVisualCidade();
    }
    
    public void atualizarVisualCidade() {
		layoutCidade.clearChildren();
		layoutDinheiro.clearChildren();
    	layoutCidade.addActor(viewCidade.getVisual(stage, construtorGui));
    	layoutDinheiro.addActor(viewCidade.getDinheiroVisual());
    }
    
    public void atualizarVisualPopulacao() {
    	layoutSatisfacao.clearChildren();
    	layoutNPopulacao.clearChildren();
    	layoutSatisfacao.addActor(viewPopulacao.getVisualSatisfacao());
    	layoutNPopulacao.addActor(viewPopulacao.getVisualNumPopulacao());
    }
    
    public void atualizarVisualCalendario() {
    	layoutCalendario.clearChildren();
    	layoutCalendario.addActor(viewCalendario.getVisual());
    }

	public void connectSubControleGui(ISubControleGui subControleGui) {
		this.subControleGui = subControleGui;
	}
	
	public void connectFactoryGui(IFactoryGui factory) {
		this.construtorGui = factory;
	}
	
	public static ISubControleVisual getInstancia() {
		if (instancia == null) {
			instancia = new SubControleVisuais();
		}
		return instancia;
	}
}
