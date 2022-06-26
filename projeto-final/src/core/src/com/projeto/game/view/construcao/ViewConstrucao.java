package com.projeto.game.view.construcao;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.projeto.game.model.construcao.IConstrucao;

public class ViewConstrucao implements IViewConstrucao {
    private IConstrucao construcao;
    private Stage stage;
    
    public Group getVisual() {
    	Group grupo = construcao.criarConstrucaoVisual();
    	
    	if (construcao.getTipo().equals("Vazio") == false) {
        	Label label = construcao.getJanela().findActor("label");
        	String texto = "Renda: " + String.valueOf(construcao.getRenda()) + "\n" + 
        	"Satisfação: " + "$" + String.valueOf(construcao.getSatisfacao());
        	
        	label.setText(texto);
    	}    	
    	return grupo;
    }
    
    public void connectStage(Stage stage) {
    	this.stage = stage;
    	this.stage.addActor(construcao.getJanela());
    }
    
    public void connect(IConstrucao construcao) {
    	this.construcao = construcao;
    }
}