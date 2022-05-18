package pt.c40task.l05wumpus;

public class Fedor extends Componente{
	public Fedor(Caverna caverna, int linha, int coluna) {
		super(caverna, linha, coluna);
	}
	
	public int getPrioridade() {
		return 1;
	}
	
	public char getId() {
		return 'f';
	}
}
