package pt.c40task.l05wumpus;

import java.util.Random;

public class Heroi extends Componente{
	private int numFlechas;
	private boolean flechaEquipada;
	private boolean pegouOuro;
	
	public Heroi(Caverna caverna, int linha, int coluna) {
		super(caverna, linha, coluna);
		this.numFlechas = 1;
		this.flechaEquipada = false;
		pegouOuro = false;
	}
	
	public int getPrioridade() {
		return 2;
	}
	
	public char getId() {
		return 'P';
	}

	public boolean getPegouOuro(){
		return pegouOuro;
	}
	
	public void capturarOuro(){
		Componente componenteBuscado = caverna.getSala(this.getLinha(), this.getColuna()).buscarId('O');
        if ( componenteBuscado != null ){
            componenteBuscado.desconectar();
            pegouOuro = true;
		}
	}

	public void equiparFlecha() {
		if ( numFlechas > 0 ) {
			flechaEquipada = true;
			numFlechas--;
		}
	}

	public boolean atirarFlecha(){
		boolean result = false;

		if ( flechaEquipada ){
			Random rand = new Random();
			int aleatorio = rand.nextInt(2);
			
			if ( aleatorio == 1 ) 
				result = true;
			numFlechas = 0;
			flechaEquipada = false;
		}
		return result;
	}

	public void matarWumpus(){
		Componente Wumpus = caverna.getSala(this.getLinha(), this.getColuna()).buscarId('W');
        if ( Wumpus != null )
			Wumpus.desconectar();
	}

}