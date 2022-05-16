package pt.c40task.l05wumpus;

public class Heroi extends Componente{
	private boolean pegouOuro;
	private boolean derrotouWumpus;
	private boolean flechaEquipada;
	private int flechasUsadas;
	
	public Heroi(Caverna caverna, int linha, int coluna) {
		super(caverna, linha, coluna);
	}
	
	public int getPrioridade() {
		return 2;
	}
	
	public String getId() {
		return "P";
	}
}
