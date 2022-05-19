package pt.c40task.l05wumpus;

public abstract class Componente {
	Caverna caverna;
	int linha;
	int coluna;
	
	public Componente(Caverna caverna, int linha, int coluna) {
		this.caverna = caverna;
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public int getLinha() {
		return this.linha;
	}
	
	public int getColuna() {
		return this.coluna;
	}

	public void setLinha(int novaLinha){
		if (novaLinha >= 0 && novaLinha <= 3) {
			this.linha = novaLinha;
		}
	}
	
	public void setColuna(int novaColuna){
		if (novaColuna >= 0 && novaColuna <= 3) {
			this.coluna = novaColuna;
		}
	}
	
	public boolean conectar() {
		boolean retorno = caverna.conectar(this);
		return retorno;
	}

	public void desconectar(){
		caverna.desconectar(this);
	}
	
	public Componente getComponente() {
		return this;
	}
	
	public abstract int getPrioridade();
	
	public abstract char getId();
}