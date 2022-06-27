package com.projeto.game.controller.construtor.calendario;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.model.calendario.Calendario;
import com.projeto.game.model.calendario.ICalendario;

public class ConstrutorCalendario implements IConstrutorCalendario {
	final static private Skin SKIN = new Skin(Gdx.files.internal("Skin/skin.json"));
	private static IConstrutorCalendario instancia;
	private IFactoryGui construtorGui;
	
	private ConstrutorCalendario() {
		
	}
	
	public void connect(IFactoryGui construtorGui) {
		this.construtorGui = construtorGui;
	}
	
	public ICalendario buildCalendario() {
		ICalendario calendario =  Calendario.getInstancia();
		Label label = construtorGui.criarLabel("", 2, "white");
		calendario.setLabel(label);
		return calendario;
	}
	
	public static IConstrutorCalendario getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorCalendario();
		}
		return instancia;
	} 
	

}
