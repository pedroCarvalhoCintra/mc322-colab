package com.projeto.game.controller.controle;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.projeto.game.model.cidade.ICidade;

public interface IControleJogo {
    public void criarAtores();
    public ICidade getCidade();
    public void conectarVisuais(Stage stage);
    public void construirConstrucao(String tipo, int linha, int coluna);
    public void removerConstrucao(int linha, int coluna);
}