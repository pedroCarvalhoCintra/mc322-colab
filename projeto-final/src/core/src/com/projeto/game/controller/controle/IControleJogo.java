package com.projeto.game.controller.controle;

import com.badlogic.gdx.scenes.scene2d.Stage;

public interface IControleJogo extends IControleProperties {
    public void criarAtores();
    public void conectarVisuais(Stage stage);
}