package com.projeto.game.controller.controle;

import com.projeto.game.controller.construtor.IFactoryConstrutor;
import com.projeto.game.controller.construtor.FactoryConstrutor;
import com.projeto.game.model.calendario.ICalendario;
import com.projeto.game.model.gerador.IFactoryGeradorDeEventos;
import com.projeto.game.model.cidade.ICidade;

public class ControleJogo implements IControleJogo {

    static private IControleJogo instancia;
    private IFactoryConstrutor construtor;
    private IFactoryGeradorDeEventos geradorDeEventos;
    private ICidade cidade;
    private ICalendario calendario;

<<<<<<< HEAD

=======
>>>>>>> a2f8395aef3edbb88075b6462d46291c8ac963d5
    private ControleJogo(){

    }

    public void criarAtores(){
        construtor = FactoryConstrutor.getInstancia();
        geradorDeEventos = construtor.criarGeradorDeEventos();
        cidade = construtor.criarCidade();
        calendario = construtor.criarCalendario();
    }

<<<<<<< HEAD
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
                    //realiza decrescimos;
                }
            }
        }
    }

    public int achaAcrescimosMoradia(IConstrucao moradia){
        int numAcrescimosMoradia = 0;
        for ( int i = moradia.getLinha() - 1; i < moradia.getLinha() + 1 && i < 10; i++){
            for ( int j = moradia.getColuna() - 1; j < moradia.getColuna() + 1 && j < 10; j++){
                if(cidade.getLayout()[i][j].getTipo().equals("Moradia")){
                    numAcrescimosMoradia++;
                }
            }
        }
        return numAcrescimosMoradia;

    }

    public void interacoesMoradiaConstruiu(ICosntrucao moradia){
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
        // realiza acrescimos
    }

=======
>>>>>>> a2f8395aef3edbb88075b6462d46291c8ac963d5
    public static IControleJogo getInstancia() {
		if (instancia == null ) {
			instancia = new ControleJogo();
		}
		return instancia;
	}
}