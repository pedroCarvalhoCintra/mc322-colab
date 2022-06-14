package com.projeto.game.model.construcao;

public interface IConstrucaoProperties {
    public int getLinha();
    public void setLinha(int linha);

    public int getColuna();
    public void setColuna(int coluna);
    
    public float getPreco();
    public void setPreco(float preco);
    
    public int getSatisfacao();
    public void setSatisfacao(int Satisfacao);
    
    public float getRenda();
    public void setRenda(float renda);
    
    public abstract String getTipo();
}
