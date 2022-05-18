package pt.c40task.l05wumpus;

public class Buraco extends Componente{
	public Buraco(Caverna caverna, int linha, int coluna) {
		super(caverna, linha, coluna);
	}
	
	public int getPrioridade() {
		return 3;
	}
	
	public char getId() {
		return 'B';
	}

	public void conectar() {
		caverna.conectar(this);
		Componente brisa1 = new Brisa(caverna, linha-1, coluna);
		Componente brisa2 = new Brisa(caverna, linha+1, coluna);
		Componente brisa3 = new Brisa(caverna, linha, coluna-1);
		Componente brisa4 = new Brisa(caverna, linha, coluna+1);
		
		brisa1.conectar();
		brisa2.conectar();
		brisa3.conectar();
		brisa4.conectar();
	}
}