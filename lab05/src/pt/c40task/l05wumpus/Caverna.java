package pt.c40task.l05wumpus;

public class Caverna {
	private Sala[][] layout;
	
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
	
	public void conectar(Componente comp) {
		int linha = comp.getLinha();
		int coluna = comp.getColuna();
		
		if (verificarPosicao(linha, coluna) == true) { //verifiação de validade de posicionamento
			layout[linha][coluna].addComponente(comp);
		}
	}
	
	public void desconectar(Componente comp) {
		int linha = comp.getLinha();
		int coluna = comp.getColuna();
		
		if (verificarPosicao(linha, coluna) == true) { //verifiação de validade de posicionamento
			layout[linha][coluna].removerComponente(comp);
		}
	}
	
	public String[][] getCaverna() {
		//Retorna uma versão em String da caverna, levando em conta prioridades.
		String cavernaStr[][] = new String[4][4];
		
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cavernaStr[i][j] = layout[i][j].getMaiorPrioridade().getId();
			}
		}
		
		return cavernaStr;
	}
	
	//TEMPORÁRIO!!!
	//TEMPORÁRIO!!!
	public void imprimirCaverna() {
		String[][] cavernaStr = this.getCaverna();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(cavernaStr[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
