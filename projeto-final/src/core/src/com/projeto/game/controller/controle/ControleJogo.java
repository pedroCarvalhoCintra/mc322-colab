package com.projeto.game.controller.controle;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.projeto.game.controller.construtor.ConstrutorConstrutoresEFactorys;
import com.projeto.game.controller.construtor.IConstrutorConstrutoresEFactorys;
import com.projeto.game.controller.construtor.calendario.IConstrutorCalendario;
import com.projeto.game.controller.construtor.cidade.IConstrutorCidade;
import com.projeto.game.controller.construtor.construcoes.IFactoryConstrucao;
import com.projeto.game.controller.construtor.gerador.IConstrutorFactoryGeradorDeEventos;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.controller.construtor.populacao.IConstrutorPopulacao;
import com.projeto.game.model.calendario.ICalendario;
import com.projeto.game.model.gerador.IFactoryGeradorDeEventos;
import com.projeto.game.model.populacao.Populacao;
import com.projeto.game.view.calendario.IViewCalendario;
import com.projeto.game.view.calendario.ViewCalendario;
import com.projeto.game.view.cidade.IViewCidade;
import com.projeto.game.view.cidade.ViewCidade;
import com.projeto.game.view.populacao.IViewPopulacao;
import com.projeto.game.view.populacao.ViewPopulacao;
import com.projeto.game.model.cidade.ICidade;
import com.projeto.game.model.construcao.IConstrucao;

public class ControleJogo implements IControleJogo {

    static private IControleJogo instancia;
    private IConstrutorConstrutoresEFactorys construtorGeral;
    private IConstrutorCalendario construtorCalendario;
    private IConstrutorCidade construtorCidade;
    private IFactoryConstrucao factoryConstrucoes;
    private IFactoryGui construtorGui;
    private IConstrutorPopulacao construtorPopulacao;
    private IFactoryGeradorDeEventos FactoryGeradorDeEventos;
    private ICidade cidade;
    private ICalendario calendario;
    private IConstrutorFactoryGeradorDeEventos ConstrutorFactoryGeradorDeEventos;
    
	private IViewCidade viewCidade = new ViewCidade();
	private IViewPopulacao viewPopulacao = new ViewPopulacao();
	private IViewCalendario viewCalendario = new ViewCalendario();
	
	private Stage stage;
	private Group layoutCidade = new Group();
	private Group layoutSatisfacao = new Group();
	private Group layoutCalendario = new Group();
	private Group layoutDinheiro = new Group();
	private Group layoutNPopulacao = new Group();
	private Group layoutBotaoPassarDia = new Group();
    
    private ControleJogo(){

    }
    
    public ICidade getCidade() {
    	return this.cidade;
    }

    public void criarAtores(){
        construtorGeral = ConstrutorConstrutoresEFactorys.getInstancia();
        construtorCidade = construtorGeral.criarConstrutorCidade();
        factoryConstrucoes = construtorGeral.criarFactoryConstrucao();
        construtorGui = construtorGeral.criarFactoryGui();
        construtorPopulacao = construtorGeral.criarConstrutorPopulacao();
        construtorCalendario = construtorGeral.criarConstrutorCalendario();
        ConstrutorFactoryGeradorDeEventos = construtorGeral.criarFactoryGeradorDeEventos();
    
        
        construtorCidade.connectConstrutorConstrucao(factoryConstrucoes);
        construtorCidade.connectConstrutorGui(construtorGui);
        construtorCidade.connectConstrutorPopulacao(construtorPopulacao);
        
        factoryConstrucoes.connect(construtorGui);
        construtorPopulacao.connect(construtorGui);
        construtorCalendario.connect(construtorGui);
        construtorGui.connect(this);

        FactoryGeradorDeEventos = ConstrutorFactoryGeradorDeEventos.buildGeradorDeEventos();
        cidade = construtorCidade.buildCidade();
        calendario = construtorCalendario.buildCalendario();
        
		viewCidade.connectCidade(cidade);
		viewPopulacao.connect(cidade.getPopulacao());
		viewCalendario.connect(calendario);
    }

    
    public void conectarVisuais(Stage stage) {
    	this.stage = stage;
    	layoutCidade.addActor(viewCidade.getVisual(stage, construtorGui));
    	layoutSatisfacao.addActor(viewPopulacao.getVisualSatisfacao());
    	layoutCalendario.addActor(viewCalendario.getVisual());
    	layoutNPopulacao.addActor(viewPopulacao.getVisualNumPopulacao());
    	layoutDinheiro.addActor(viewCidade.getDinheiroVisual());
    	layoutBotaoPassarDia.addActor(adicionarBotaoPassarDia());
    	
    	layoutCidade.setPosition(45, 45);
    	layoutSatisfacao.setPosition(stage.getWidth()-200, stage.getHeight()/2);
    	layoutCalendario.setPosition(stage.getWidth()-200, stage.getHeight()/2 + 150);
    	layoutNPopulacao.setPosition(stage.getWidth()-650, stage.getHeight()/2 + 150);
    	layoutDinheiro.setPosition(stage.getWidth()-650, stage.getHeight()/2);
    	layoutBotaoPassarDia.setPosition(stage.getWidth()-200, stage.getHeight()/2 -150);

    	stage.addActor(layoutCidade);
    	stage.addActor(layoutSatisfacao);
    	stage.addActor(layoutCalendario);
    	stage.addActor(layoutNPopulacao);
    	stage.addActor(layoutDinheiro);
    	stage.addActor(layoutBotaoPassarDia);
    }
    
    public void construirConstrucao(String tipo, int linha, int coluna) {
    	IConstrucao novo;
		novo = factoryConstrucoes.criarConstrucao(tipo, linha, coluna);
		//System.out.println("LINHA: " + novo.getLinha() + " COLUNA " + novo.getColuna());		
		
		try {
			cidade.adicionarConstrucao(novo);
	    	cidade.getPopulacao().addSatisfacao(10);
	    	cidade.getPopulacao().addPopulacao(200);
	    	this.atualizarVisualPopulacao();
	    	passarDia();
			
		} catch (NullPointerException nullPoint) {
			String texto = "You don't have enough money to build this!\nYou're missing $" + String.valueOf(novo.getPreco() - cidade.getDinheiro()) + "!";
    		Dialog erro = construtorGui.criarDialog("Error!", texto, 1, 1000, 150);
    		
    		erro.show(stage);	
		}
		
		catch (IllegalArgumentException illegal) {
			String texto = "You cannot build another Town Hall! A city can only have one Town Hall. \nThat's enough bureaucracy, right?";
    		Dialog erro = construtorGui.criarDialog("Error!", texto, 1, 1000, 150);
    		
    		erro.show(stage);	
		}
		
		catch (Exception exception){
			String texto = "Some sort of unhandled exception has happened. That's sad.\nPlease send a report at the game's repository so we can get it fixed ASAP!\nThink of the good part: your game could've crashed!";
    		Dialog erro = construtorGui.criarDialog("Error!", texto, 1, 1000, 150);
    		
    		erro.show(stage);	
		}
		
		finally {
			
		}
		
    	atualizarVisualCidade();
    }
    
    public void removerConstrucao(int linha, int coluna) {
    	IConstrucao novo;
		try {
			cidade.removerConstrucao(linha, coluna);
			novo = factoryConstrucoes.criarConstrucao("Vazio", linha, coluna);
			cidade.adicionarConstrucao(novo);
	    	cidade.getPopulacao().addSatisfacao(10);
	    	this.atualizarVisualPopulacao();
	    	passarDia();
			
		} catch (Exception exception) {
			String texto = "It seems our engineers found a problem as they were demolishing this building.\nMaybe it's haunted!";
    		Dialog erro = construtorGui.criarDialog("Error!", texto, 1, 1000, 150);
    		erro.show(stage);	
		}
		
		finally {
	    	atualizarVisualCidade();
		}
    }
    
    public void passarDia() {
    	this.calendario.passarDia();
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
    
    public Button adicionarBotaoPassarDia() {
    	Button passarDia = construtorGui.criarBotao("texto", "Next Day", 250, 100, 0, 0);
		ClickListener listenerClick = new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				passarDia();
			}
		};
		
		passarDia.addListener(listenerClick);
		return passarDia;
    }
    
    public static IControleJogo getInstancia() {
		if (instancia == null ) {
			instancia = new ControleJogo();
		}
		return instancia;
	}
}