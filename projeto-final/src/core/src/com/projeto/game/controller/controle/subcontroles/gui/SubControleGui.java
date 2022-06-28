package com.projeto.game.controller.controle.subcontroles.gui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.controller.controle.subcontroles.calendario.ISubControleCalendario;
import com.projeto.game.controller.controle.subcontroles.visual.ISubControleVisual;
import com.projeto.game.model.evento.IEvento;

public class SubControleGui implements ISubControleGui {
	static private ISubControleGui instancia;
	
	private IFactoryGui construtorGui;
	private ISubControleCalendario subControleCalendario;
	private ISubControleVisual subControleVisual;
	private Stage stage;
	
	private SubControleGui() {
		
	}
	
	public void adicionarDialogoExcecao(String error) {
		Dialog erro = construtorGui.criarDialog("Error!", error, 1, 1000, 150);
		erro.show(stage);
	}
	
	public void adicionarDialogoEvento(IEvento eventoAleatorio) {
    	Dialog dialogo = construtorGui.criarDialog("Random Event!", eventoAleatorio.getDescricao(), 1, 1000, 250);
    	dialogo.show(stage);
	}
	
    public Button adicionarBotaoPassarDia() {
    	Button passarDia = construtorGui.criarBotao("texto", "Next Day", 250, 80, 0, 0);
		ClickListener listenerClick = new ClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				subControleCalendario.passarDia();
				subControleVisual.atualizar();
			}
		};
		
		passarDia.addListener(listenerClick);
		return passarDia;
    }

	public void connectStage(Stage stage) {
		this.stage = stage;		
	}

	public void connectSubControleCalendario(ISubControleCalendario subControleCalendario) {
		this.subControleCalendario = subControleCalendario;
	}
	
	public void connectSubControleVisual(ISubControleVisual subControleVisual) {
		this.subControleVisual = subControleVisual;
	}
	
	public void connectFactoryGui(IFactoryGui factory) {
		this.construtorGui = factory;
	}
	
	public static ISubControleGui getInstancia() {
		if (instancia == null) {
			instancia = new SubControleGui();
		}
		return instancia;
	}
}
