package pt.c40task.l05wumpus;

import javax.lang.model.element.NestingKind;

public class Wumpus extends Componente{

	public Wumpus(Caverna caverna, int linha, int coluna) {
		super(caverna, linha, coluna);
	}
	
	public int getPrioridade() {
		return 3;
	}
	
	public String getId() {
		return "W";
	}

	public void conectar() {
		caverna.conectar(this);
		Componete fedor1 = new Fedor(caverna, linha-1, coluna);
		Componete fedor2 = new Fedor(caverna, linha+1, coluna);
		Componete fedor3 = new Fedor(caverna, linha, coluna-1);
		Componete fedor4 = new Fedor(caverna, linha, coluna+1);
		
		fedor1.conectar();
		fedor2.conectar();
		fedor3.conectar();
		fedor4.conectar();
	}	

}
