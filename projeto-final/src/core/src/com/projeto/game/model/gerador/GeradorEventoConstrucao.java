package com.projeto.game.model.gerador;

import com.projeto.game.model.evento.IEvento;
import com.projeto.game.model.construcao.IConstrucao;

public class GeradorEventoConstrucao implements IGerarEventoConstrucao {
    
    private static IGerarEventoConstrucao instancia;

    private GeradorEventoConstrucao(){

    }


    public IEvento gerarEventoConstrucao(IConstrucao construcao, int data){
        EventoConstrucao eventoConstrucao;
        eventoConstrucao.setData(data);
        eventoConstrucao.connectConstrucao(construcao);
        return eventoConstrucao;
    }





    public static IGerarEventoConstrucao getInstancia() {
		if ( instancia == null ) {
			instancia = new GeradorEventoConstrucao();
		}
		return instancia;
	}
}