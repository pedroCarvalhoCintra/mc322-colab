package com.projeto.game.controller.controle;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.projeto.game.controller.construtor.ConstrutorConstrutoresEFactorys;
import com.projeto.game.controller.construtor.IConstrutorConstrutoresEFactorys;
import com.projeto.game.controller.construtor.calendario.IConstrutorCalendario;
import com.projeto.game.controller.construtor.cidade.IConstrutorCidade;
import com.projeto.game.controller.construtor.construcoes.IFactoryConstrucao;
import com.projeto.game.controller.construtor.gerador.IConstrutorConstrutorGeradorDeEventos;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.controller.construtor.populacao.IConstrutorPopulacao;
import com.projeto.game.controller.controle.subcontroles.calendario.ISubControleCalendario;
import com.projeto.game.controller.controle.subcontroles.calendario.SubControleCalendario;
import com.projeto.game.controller.controle.subcontroles.cidade.ISubControleCidade;
import com.projeto.game.controller.controle.subcontroles.cidade.SubControleCidade;
import com.projeto.game.controller.controle.subcontroles.gui.ISubControleGui;
import com.projeto.game.controller.controle.subcontroles.gui.SubControleGui;
import com.projeto.game.controller.controle.subcontroles.visual.ISubControleVisual;
import com.projeto.game.controller.controle.subcontroles.visual.SubControleVisuais;
import com.projeto.game.model.calendario.ICalendario;
import com.projeto.game.model.gerador.IConstrutorGeradorDeEventos;
import com.projeto.game.view.calendario.IViewCalendario;
import com.projeto.game.view.calendario.ViewCalendario;
import com.projeto.game.view.cidade.IViewCidade;
import com.projeto.game.view.cidade.ViewCidade;
import com.projeto.game.view.populacao.IViewPopulacao;
import com.projeto.game.view.populacao.ViewPopulacao;
import com.projeto.game.model.cidade.ICidade;

public class ControleJogo implements IControleJogo {

    static private IControleJogo instancia;
    private IConstrutorConstrutoresEFactorys construtorGeral;
    private IConstrutorCalendario construtorCalendario;
    private IConstrutorCidade construtorCidade;
    private IFactoryConstrucao factoryConstrucoes;
    private IFactoryGui construtorGui;
    private IConstrutorPopulacao construtorPopulacao;
    private IConstrutorGeradorDeEventos geradorDeEventos;
    private ICidade cidade;
    private ICalendario calendario;
    private IConstrutorConstrutorGeradorDeEventos ConstrutorFactoryGeradorDeEventos;
    
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
	
	private ISubControleCalendario subControleCalendario;
	private ISubControleGui subControleGui;
	private ISubControleCidade subControleCidade;
	private ISubControleVisual subControleVisual;
    
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
    
        subControleCalendario = SubControleCalendario.getInstancia();
        
        subControleCidade = SubControleCidade.getInstancia();
        
        subControleGui = SubControleGui.getInstancia();
        
        subControleVisual = SubControleVisuais.getInstancia();
        
        
        subControleGui.connectStage(stage);
        subControleGui.connectSubControleCalendario(subControleCalendario);
        subControleGui.connectFactoryGui(construtorGui);
        subControleGui.connectSubControleVisual(subControleVisual);
        subControleVisual.connectStage(stage);
        subControleVisual.connectSubControleGui(subControleGui);
        subControleVisual.connectViewCalendario(viewCalendario);
        subControleVisual.connectViewCidade(viewCidade);
        subControleVisual.connectViewPopulacao(viewPopulacao);
        subControleVisual.connectFactoryGui(construtorGui);
        
        construtorCidade.connectConstrutorConstrucao(factoryConstrucoes);
        construtorCidade.connectConstrutorGui(construtorGui);
        construtorCidade.connectConstrutorPopulacao(construtorPopulacao);
        
        factoryConstrucoes.connect(construtorGui);
        construtorPopulacao.connect(construtorGui);
        construtorCalendario.connect(construtorGui);
        construtorGui.connect(subControleCidade);

        geradorDeEventos = ConstrutorFactoryGeradorDeEventos.buildGeradorDeEventos();
        cidade = construtorCidade.buildCidade();
        calendario = construtorCalendario.buildCalendario();
        calendario.connectCidade(cidade);
        
        subControleCalendario.connectGeradorEventos(geradorDeEventos);
        subControleCalendario.connectCalendario(calendario);
        subControleCalendario.connectSubControleGui(subControleGui);
        subControleCidade.connectCidade(cidade);
        subControleCidade.connectFactoryConstrucoes(factoryConstrucoes);
        subControleCidade.connectSubControleCalendario(subControleCalendario);
        subControleCidade.connectSubControleGui(subControleGui);
        subControleCidade.connectSubControleVisual(subControleVisual);
        
		viewCidade.connectCidade(cidade);
		viewPopulacao.connect(cidade.getPopulacao());
		viewCalendario.connect(calendario);
    }

    
    public void conectarVisuais(Stage stage) {
    	this.stage = stage;
    	
    	
    	
    	subControleGui.connectStage(stage);
    	subControleVisual.connectStage(stage);
    	
    	subControleVisual.criarGruposVisuais();
    	subControleVisual.conectarVisuais();
    }
    
    public IFactoryGui getFactoryGui() {
    	return this.construtorGui;
    }
    
    public static IControleJogo getInstancia() {
		if (instancia == null ) {
			instancia = new ControleJogo();
		}
		return instancia;
	}
    
    public void connectStage(Stage stage) {
    	this.stage = stage;
    }
}