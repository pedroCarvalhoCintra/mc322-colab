package pt.c40task.l05wumpus;

public class Buraco extends Componente{
	public Buraco(Caverna caverna, int linha, int coluna) {
		super(caverna, linha, coluna);
	}
	
	public int getPrioridade() {
		return 3;
	}
	
	public String getId() {
		return "B";
	}

	public void conectar() {
		caverna.conectar(this);
		Componete brisa1 = new Fedor(caverna, linha-1, coluna);
		Componete brisa2 = new Fedor(caverna, linha+1, coluna);
		Componete brisa3 = new Fedor(caverna, linha, coluna-1);
		Componete brisa4 = new Fedor(caverna, linha, coluna+1);
		
		brisa1.conectar();
		brisa2.conectar();
		brisa3.conectar();
		brisa4.conectar();
	}	
