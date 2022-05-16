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
}
