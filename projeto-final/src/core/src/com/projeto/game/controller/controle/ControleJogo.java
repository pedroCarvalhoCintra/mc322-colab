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

    private ControleJogo(){

    }

    public void criarAtores(){
        construtor = FactoryConstrutor.getInstancia();
        geradorDeEventos = construtor.criarGeradorDeEventos();
        cidade = construtor.criarCidade();
        calendario = construtor.criarCalendario();
    }

    public static IControleJogo getInstancia() {
		if (instancia == null ) {
			instancia = new ControleJogo();
		}
		return instancia;
	}
}