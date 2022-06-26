package com.projeto.game.model.populacao;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

public interface IPopulacaoProperties {
    public int getNumHabitantes();
    public int getSatisfacao();
    public double getRendaPopulacao();
    
    public void setLabel(Label label);
    public Label getLabel();
    
    public void addPopulacao(int num);
    public void addRenda(double num);
    public void addSatisfacao(int num);
}
