package pt.c40task.l05wumpus;

public class Ouro extends Componente {
	public Ouro(Caverna caverna, int linha, int coluna) {
		super(caverna, linha, coluna);
	}
	
	public int getPrioridade() {
		return 3;
	}
	
	public char getId() {
		return 'O';
	}
}
