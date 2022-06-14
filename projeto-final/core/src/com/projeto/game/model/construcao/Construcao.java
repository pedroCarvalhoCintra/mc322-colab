package com.projeto.game.model.construcao;

public abstract class Construcao implements IConstrucao {
	protected int linha;
    protected int coluna;
    protected int satisfacao;
    protected float preco;
    protected float renda;
    
    public Construcao (){
    }

    public int getLinha(){
        return this.linha;
    }

    public int getColuna(){
        return this.linha;
    }
    
    public int getSatisfacao() {
    	return this.satisfacao;
    }

    public float getPreco() {
		return this.preco;
	}

	public float getRenda() {
		return this.renda;
	}

	public void setLinha(int linha){
        this.linha = linha;
    }

    public void setColuna(int coluna){
        this.coluna = coluna;
    }

    public void setSatisfacao(int satisfacao) {
		this.satisfacao = satisfacao;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setRenda(float renda) {
		this.renda = renda;
	}

	public abstract Construcao buildConstrucao();
    public abstract String getTipo();
}
