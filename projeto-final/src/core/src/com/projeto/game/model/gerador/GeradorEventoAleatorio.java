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
        EventoAleatorio eventoAleatorio = new EventoAleatorio();
        IStrategyEventoAleatorio strategy;
        String texto = "";

        Random rand = new Random();
        int n = rand.nextInt(3) + 1;

        switch (n) {
          case 1:
              strategy = new EventoAleatorioGreveGeral();
              texto = "Major Strike!\nThe labour unions have called a strike for next week, within ten days!\nSorting this out will require 20% of our funds on that day, so be careful!";
              break;
          case 2:
              strategy = new EventoAleatorioMigracao();
              texto = "More people!\nPeople from nearby cities have moved to our cities, and will arrive in ten days.\nLet's hope they enjoy their stay, and that you can handle this new challenge.";
              break;
          case 3:
              strategy = new EventoAleatorioRepasseEstadual();
              texto = "More funds!\nThe state treasury has approved more funding for our city.\nThis extra cash will be deposited next week, withing ten days.";
              break; 
          default:
              strategy = new EventoAleatorioMigracao();
        	  break;
        }
        
        eventoAleatorio.setData(data);
        eventoAleatorio.setStrategy(strategy);
        eventoAleatorio.setDescricao(texto);

        return eventoAleatorio;
    }


    public static IGerarEventoAleatorio getInstancia() {
		    if ( instancia == null ) {
			    instancia = new GeradorEventoAleatorio();
		    }
		    return instancia;
	  }

}