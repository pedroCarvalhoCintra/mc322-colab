package com.projeto.game.model.construcao;

public interface IConstrucaoProperties {
    public int getLinha();
    public void setLinha();

    public int getColuna();
    public void setColuna();

    public int getDificuldade();

    public abstract String getTipo();
    public abstract double getPreco();
    public abstract double getRenda();
    public abstract int getSatisfacao(); 
}
