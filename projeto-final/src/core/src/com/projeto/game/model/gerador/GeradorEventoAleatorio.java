package com.projeto.game.model.gerador;

import com.projeto.game.model.evento.IEvento;

public class GeradorEventoAleatorio implements IGerarEventoAleatorio {
    
    private static IGerarEventoAleatorio instancia;

    private GeradorEventoAleatorio(){

    }


    public IEvento gerarEventoAleatorio(int data){
        EventoAleatorio eventoAleatorio;
        eventoAleatorio.setData(data);

        


    }





    public static IGerarEventoAleatorio getInstancia() {
		    if ( instancia == null ) {
			    instancia = new GeradorEventoAleatorio();
		    }
		    return instancia;
	  }

}