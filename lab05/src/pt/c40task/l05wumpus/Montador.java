package pt.c40task.l05wumpus;

public class Montador {
	private Caverna caverna; //MUDAR PRA PRIVATE
	
	public Montador(String[][] layout) {
		caverna = new Caverna();
		for (int i = 0; i < 16; i++) { //16 salas
			int linha = Integer.parseInt(layout[i][0]) - 1;
			int coluna = Integer.parseInt(layout[i][1]) - 1;
			Componente comp;
			
			switch(layout[i][2]) {
			case "P":
				comp = new Heroi(caverna, linha, coluna);
				break;
			case "W":
				comp = new Wumpus(caverna, linha, coluna);
				break;
			case "B":
				comp = new Buraco(caverna, linha, coluna);
				break;
			case "O":
				comp = new Ouro(caverna, linha, coluna);
				break;
			case "_":
				comp = new Vazio(caverna, linha, coluna);
				break;	
			default:
				comp = new Vazio(caverna, linha, coluna);
				break;
			}
			
			if (layout[i][2].equals("_") == false) {
				Componente compVazio = new Vazio(caverna, linha, coluna);
				caverna.conectar(compVazio);
			}
			
			caverna.conectar(comp);
		}
	}
	
	public void imprimir() {
		this.caverna.imprimirCaverna();
	}
}
