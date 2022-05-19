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
		return this.pegouOuro;
	}
	
	public boolean getFlechaEquipada() {
		return this.flechaEquipada;
	}
	
	public void setPegouOuro(boolean valor) {
		this.pegouOuro = valor;
	}

	public boolean equiparFlecha() {
		boolean valido = false;
		if ( numFlechas > 0 ) {
			flechaEquipada = true;
			numFlechas--;
			valido = true;
		}
		
		return valido;
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
	
	public boolean conectar() {
		boolean retorno = caverna.conectar(this);
		return retorno;
	}

}