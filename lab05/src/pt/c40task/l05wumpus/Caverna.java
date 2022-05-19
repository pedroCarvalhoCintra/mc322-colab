package pt.c40task.l05wumpus;

public class Caverna {
	private Sala[][] layout;
	private Heroi heroi;
	
	public Caverna() {
		layout = new Sala[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				layout[i][j] = new Sala();
			}
		}
	}
	
	public boolean verificarPosicao(int linha, int coluna) {
		boolean valido = false;
		
		if (linha >= 0 && linha <= 3 && coluna >= 0 && coluna <= 3) {
			valido = true;
		}
		
		return valido;
	}
	
	public boolean conectar(Heroi heroi) {
		int linha = heroi.getLinha();
		int coluna = heroi.getColuna();
		boolean sucesso = false;
		
		if (verificarPosicao(linha, coluna) == true) { //verificação de validade de posicionamento
			layout[linha][coluna].addComponente(heroi);
			this.setHeroi(heroi);
			sucesso = true;
		}
		
		return sucesso;
	}
	
	public boolean conectar(Componente comp) {
		int linha = comp.getLinha();
		int coluna = comp.getColuna();
		boolean sucesso = false;
		
		if (verificarPosicao(linha, coluna) == true) { //verificação de validade de posicionamento
			sucesso = layout[linha][coluna].addComponente(comp);
		}
		
		return sucesso;
	}
	
	public void desconectar(Componente comp) {
		int linha = comp.getLinha();
		int coluna = comp.getColuna();
		
		if (verificarPosicao(linha, coluna) == true) { //verificação de validade de posicionamento
			layout[linha][coluna].removerComponente(comp);
		}
	}
	
	public void setHeroi(Heroi heroi) {
		this.heroi = heroi;
	}
	
	public Heroi getHeroi() {
		return this.heroi;
	}
	
	public Sala getSala(int linha, int coluna) {
		return layout[linha][coluna];
	}
	
	public char[][] getCaverna() {
		//Retorna uma versão em char da caverna, levando em conta prioridades.
		char cavernaChar[][] = new char[4][4];
		
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (layout[i][j].getVisitado() == false) {
					cavernaChar[i][j] = '-';
				}
				
				else {
					cavernaChar[i][j] = layout[i][j].getMaiorPrioridade().getId();
				}
			}
		}
		
		return cavernaChar;
	}
	
	public void imprimirCaverna() {
		char[][] cavernaStr = this.getCaverna();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(cavernaStr[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
