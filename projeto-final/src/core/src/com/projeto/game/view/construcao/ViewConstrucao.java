package com.projeto.game.view.construcao;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.model.construcao.IConstrucao;

public class ViewConstrucao implements IViewConstrucao {
    private IConstrucao construcao;
    private IFactoryGui fabricaGui;
    private Stage stage;
    
    public Group getVisual() {
    	Group grupo = construcao.criarConstrucaoVisual();
    	
    	if (construcao.getTipo().equals("Vazio") == false) {
    		Label titulo = construcao.getJanela().getTitleLabel();
        	Label label = construcao.getJanela().findActor("label");
        	String texto = "Income: " + "$" + String.valueOf(construcao.getRenda()) + "\n\n" + 
        	"Happiness: " + String.valueOf(construcao.getSatisfacao());
        	
        	if (construcao.getConstruido() == false) {
        		titulo.setText(construcao.getTipo() + " (Building In Progress)");
        	}
        	
        	else {
        		titulo.setText(construcao.getTipo());
        	}
        	
        	label.setText(texto);
        	titulo.setFontScale(1.2f);
        	
        	if (construcao.getJanela().findActor("destruir") == null) {
            	Button botaoDestruir = fabricaGui.criarBotao("Destruir", "Demolish", 1000, 1000, construcao.getLinha(), construcao.getColuna());
            	construcao.getJanela().row();
            	construcao.getJanela().add(botaoDestruir).expand();
        	}
    	}
    	return grupo;
    }
    
    public void connectStage(Stage stage) {
    	this.stage = stage;
    	construcao.getJanela().setPosition(1075, 80);
    	this.stage.addActor(construcao.getJanela());
    }
    
    public void connect(IConstrucao construcao) {
    	this.construcao = construcao;
    }
    
    public void connectGui(IFactoryGui fabricaGui) {
    	this.fabricaGui = fabricaGui;
    }
}