package com.projeto.game.controller.controle.subcontroles.visual;

public interface ISubControleVisual extends IRFactoryGui, IRConnectStage, IRConnectSubControleGui, IRConnectViews, IAtualizar {
	public void criarGruposVisuais();
    public void conectarVisuais();

}
