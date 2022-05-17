package pt.c40task.l05wumpus;

public class Heroi extends Componente{
	private int numeFlechas;
	private boolean flechaEquipada;
	private boolean pegouOuro;
	private boolean derrotouWumpus;
	
	public Heroi(Caverna caverna, int linha, int coluna) {
		super(caverna, linha, coluna);
		this.numeFlechas = 1;
		this.flechaEquipada = false;
		pegouOuro = false;
		derrotouWumpus = false;
	}
	
	public int getPrioridade() {
		return 2;
	}
	
	public String getId() {
		return "P";
	}
	
	public capturaOuro(){
		Componente componenteBuscado = caverna.getSala(player.getLinha(), player.getColuna()).buscaID("O");
        if ( componenteBuscado != NUll ){
            componenteBuscado.desconectar();
            pegouOuro = true;
		}
	}


	public void equipaFlecha(){
		if ( numeFlechas > 0 ){
			flechaEquipada = true;
			numeFlechas--;
		}
	}



}
