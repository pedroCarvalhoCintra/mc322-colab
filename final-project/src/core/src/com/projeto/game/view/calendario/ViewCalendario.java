package com.projeto.game.view.calendario;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.projeto.game.model.calendario.ICalendario;

public class ViewCalendario implements IViewCalendario {
    private ICalendario calendario;
    
	public Group getVisual() {
		Group grupo = calendario.criarCalendarioVisual();
		
		return grupo;
	}

	public void connect(ICalendario calendario) {
		this.calendario = calendario;
	}

}