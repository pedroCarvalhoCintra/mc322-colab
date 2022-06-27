package com.projeto.game.controller.controle;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
	private Group forStage = new Group();
    
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

    public int acharDecrescimos(IConstrucao moradia){
        int numDecrescimos = 0;
        for ( int i = moradia.getLinha() - 1; i < moradia.getLinha() + 1 && i < 10; i++){
            for ( int j = moradia.getColuna() - 1; j < moradia.getColuna() + 1 && j < 10; j++){
                if(cidade.getLayout()[i][j].getTipo().equals("Industria")){
                    numDecrescimos++;
                }
            }
        }
        return numDecrescimos;

    }

    public void interacoesMoradiaPassouDia(){
        int numDecrescimos = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if ( cidade.getLayout()[i][j].getTipo().equals("Moradia")){
                    numDecrescimos = acharDecrescimos(cidade.getLayout()[i][j]);
                    cidade.getPopulacao().addSatisfacao(numDecrescimos*1);
                }
            }
        }
    }

    public void interacoesMoradiaConstruiu(IConstrucao moradia){
        int numAcrescimosMoradia = 0 ;
        int numAcrescimosEscola = 0;
        int numAcrescimosHospital = 0;

        for ( int i = moradia.getLinha() - 1; i < moradia.getLinha() + 1 && i < 10; i++){
            for ( int j = moradia.getColuna() - 1; j < moradia.getColuna() + 1 && j < 10; j++){
                if(cidade.getLayout()[i][j].getTipo().equals("Moradia")){
                    numAcrescimosMoradia++;
                }
                else if(cidade.getLayout()[i][j].getTipo().equals("Escola")){
                    numAcrescimosEscola++;
                }
                else if(cidade.getLayout()[i][j].getTipo().equals("Hospital")){
                    numAcrescimosHospital++;
                }
            }
        }
        // realiza acrescimos de cada tipo;
        cidade.getPopulacao().addSatisfacao(numAcrescimosMoradia*1);
        cidade.getPopulacao().addSatisfacao(numAcrescimosEscola*5);
        cidade.getPopulacao().addSatisfacao(numAcrescimosHospital*10);
    }
    
    public void conectarVisuais(Stage stage) {
    	this.stage = stage;
    	Table layoutCidade = viewCidade.getVisual(stage, construtorGui);
    	Group layoutPopulacao = viewPopulacao.getVisual();
    	Group layoutCalendario = viewCalendario.getVisual();
    	
    	forStage.setPosition(45, 45);
    	layoutPopulacao.setPosition(stage.getWidth()-150, stage.getHeight()/2);
    	layoutCalendario.setPosition(stage.getWidth()-150, stage.getHeight()/2 + 150);
    	
    	forStage.addActor(layoutCidade);
    	stage.addActor(forStage);
    	stage.addActor(layoutPopulacao);
    	stage.addActor(layoutCalendario);

    }
    
    public void construirConstrucao(String tipo, int linha, int coluna) {
    	IConstrucao novo;
		novo = factoryConstrucoes.criarConstrucao(tipo, linha, coluna);
		//System.out.println("LINHA: " + novo.getLinha() + " COLUNA " + novo.getColuna());

		boolean resultado = cidade.adicionarConstrucao(novo);
		
		forStage.clearChildren();
		
		if (resultado == true) {
	    	forStage.addActor(viewCidade.getVisual(stage, construtorGui));
		}
		
		else {			
	    	forStage.addActor(viewCidade.getVisual(stage, construtorGui));
		}
    }
    
    public void removerConstrucao(int linha, int coluna) {
    	IConstrucao novo;
    	boolean resultado = cidade.removerConstrucao(linha, coluna);
    	
		forStage.clearChildren();

    	if (resultado == true) {
    		novo = factoryConstrucoes.criarConstrucao("Vazio", linha, coluna);
    		this.construirConstrucao("Vazio", linha, coluna);
	    	forStage.addActor(viewCidade.getVisual(stage, construtorGui));
    	}
    	
    	else {
	    	forStage.addActor(viewCidade.getVisual(stage, construtorGui));
    	}
    }

    public static IControleJogo getInstancia() {
		if (instancia == null ) {
			instancia = new ControleJogo();
		}
		return instancia;
	}
}