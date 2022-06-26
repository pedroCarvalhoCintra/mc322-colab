package com.projeto.game.controller.controle;

import com.projeto.game.controller.construtor.IFactoryConstrutor;
import com.projeto.game.controller.construtor.calendario.ConstrutorCalendario;
import com.projeto.game.controller.construtor.calendario.IConstrutorCalendario;
import com.projeto.game.controller.construtor.cidade.ConstrutorCidade;
import com.projeto.game.controller.construtor.cidade.IConstrutorCidade;
import com.projeto.game.controller.construtor.construcoes.FactoryConstrucao;
import com.projeto.game.controller.construtor.construcoes.IFactoryConstrucao;
import com.projeto.game.controller.construtor.gui.FactoryGui;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.controller.construtor.populacao.ConstrutorPopulacao;
import com.projeto.game.controller.construtor.populacao.IConstrutorPopulacao;
import com.projeto.game.controller.construtor.FactoryConstrutor;
import com.projeto.game.model.calendario.ICalendario;
import com.projeto.game.model.gerador.IFactoryGeradorDeEventos;
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

    private Window janelaConstrucoes;

    private ControleJogo(){

    }
    
    public ICidade getCidade() {
    	return this.cidade;
    }

    public void criarAtores(){
        construtorGeral = FactoryConstrutor.getInstancia();
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

        janelaConstrucoes = construtorGui.criarJanela("construcao", "What would you like to build?", null, 750, 450);

        FactoryGeradorDeEventos = ConstrutorFactoryGeradorDeEventos.buildGeradorDeEventos();
        cidade = construtorCidade.buildCidade();
        calendario = construtorCalendario.buildCalendario();
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

    public static IControleJogo getInstancia() {
		if (instancia == null ) {
			instancia = new ControleJogo();
		}
		return instancia;
	}
}