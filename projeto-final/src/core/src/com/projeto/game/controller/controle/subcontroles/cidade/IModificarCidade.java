package com.projeto.game.controller.controle.subcontroles.cidade;

public interface IModificarCidade {
    public void construirConstrucao(String tipo, int linha, int coluna);
    public void removerConstrucao(int linha, int coluna);
}
