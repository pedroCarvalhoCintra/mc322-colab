package com.projeto.game.model.gerador;

import com.projeto.game.model.evento.EventoConstrucao;
import com.projeto.game.model.construcao.IConstrucao;

public class GeradorEventoConstrucao implements IGerarEventoConstrucao {
    
    private static IGerarEventoConstrucao instancia;

    private GeradorEventoConstrucao(){

    }

    public EventoConstrucao gerarEventoConstrucao(IConstrucao construcao, int data){
        EventoConstrucao eventoConstrucao = new EventoConstrucao();
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