package com.projeto.game.model.gerador;

import java.util.Random;
import com.projeto.game.model.evento.IEvento;

public class GeradorDeEventos implements IGerador {
	public IEvento gerarEvento() {
		Random rand = new Random();
		int n = rand.nextInt(100) + 1;
		
		
	}
}
