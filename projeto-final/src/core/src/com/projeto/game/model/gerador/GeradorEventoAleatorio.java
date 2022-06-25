package com.projeto.game.model.gerador;

import java.util.Random;
import com.projeto.game.model.evento.EventoAleatorio;
import com.projeto.game.model.evento.IStrategyEventoAleatorio;
import com.projeto.game.model.evento.aleatorio.EventoAleatorioGreveGeral;
import com.projeto.game.model.evento.aleatorio.EventoAleatorioMigracao;
import com.projeto.game.model.evento.aleatorio.EventoAleatorioRepasseEstadual;

public class GeradorEventoAleatorio implements IGerarEventoAleatorio {
    
    private static IGerarEventoAleatorio instancia;

    private GeradorEventoAleatorio(){

    }


    public EventoAleatorio gerarEventoAleatorio(int data){
        EventoAleatorio eventoAleatorio;
        eventoAleatorio.setData(data);
        IStrategyEventoAleatorio strategy;

        Random rand = new Random();
        int n = rand.nextInt(3) + 1;

        switch (n) {
          case 1:
              strategy = new EventoAleatorioGreveGeral();
              break;
          case 2:
              strategy = new EventoAleatorioMigracao();
              break;
          case 3:
              strategy = new EventoAleatorioRepasseEstadual();
              break;
        }
        
        eventoAleatorio.setStrategy(strategy);

        return eventoAleatorio;
    }


    public static IGerarEventoAleatorio getInstancia() {
		    if ( instancia == null ) {
			    instancia = new GeradorEventoAleatorio();
		    }
		    return instancia;
	  }

}