package pt.c40task.l05wumpus;

public class Brisa extends Componente{
	public Brisa(Caverna caverna, int linha, int coluna) {
		super(caverna, linha, coluna);
	}
	
	public int getPrioridade() {
		return 0;
	}
	
	public String getId() {
		return "b";
	}
}
