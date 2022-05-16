package pt.c40task.l05wumpus;

public class Vazio extends Componente {
	public Vazio(Caverna caverna, int linha, int coluna) {
		super(caverna, linha, coluna);
	}
	
	public int getPrioridade() {
		return -1;
	}
	
	public String getId() {
		return "#";
	}
}
