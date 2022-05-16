package pt.c40task.l05wumpus;

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
}
