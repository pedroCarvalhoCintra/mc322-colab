package com.projeto.game.model.cidade;

import com.projeto.game.model.populacao.IPopulacao;

public class Cidade implements ICidade {
    private Construcao[][] layout;
    private IPopulacao populacao;
    private int dinheiro;
    private int dificuldade

    public Cidade( int dificuldade){
        layout = new Construcao[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				layout[i][j] = new Vazio(i, j, dificuldade);
			}
		}

        this.populacao = null;
        this.dinheiro = 100000000000000;
        this.dificuldade = dificuldade;
    }

    public int getDinheiro()




}
