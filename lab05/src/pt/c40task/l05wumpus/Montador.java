package pt.c40task.l05wumpus;

public class Montador {
	String layout[][];
	private int nPlayers;
	private int nBuracos;
	private int nWumpus;
	private int nOuro;
	
	public Montador(Toolkit tk) {
		nPlayers = 0;
		nBuracos = 0;
		nWumpus = 0;
		nOuro = 0;
		layout = tk.retrieveCave();
	}
	
	public Caverna construirCaverna() {
		Caverna caverna = new Caverna();
		
		caverna = new Caverna();
		for (int i = 0; i < layout.length; i++) {
			int linha = Integer.parseInt(layout[i][0]) - 1;
			int coluna = Integer.parseInt(layout[i][1]) - 1;

			switch(layout[i][2]) {
			case "P":
				if (verificarPosHeroi(linha, coluna) == false) {
					System.out.println("ERRO: Caverna Inválida. Desligando... - COD DE ERRO: 001");
					return null;
				}
				criarHeroi(caverna, linha, coluna);
				break;
			case "W":
				criarWumpus(caverna, linha, coluna);
				break;
			case "B":
				criarBuraco(caverna, linha, coluna);
				break;
			case "O":
				criarOuro(caverna, linha, coluna);
				break;
			case "_":
				criarVazio(caverna, linha, coluna);
				break;	
			default:
				criarVazio(caverna, linha, coluna);
				break;
			}
			
			if (layout[i][2].equals("_") == false) {
				criarVazio(caverna, linha, coluna); //Sempre colocamos um componente vazio nas salas, para facilitar caso todos os outros componentes sejam removidos.
			}
		}
		
		
		if (veriricarCaverna() == false) {
			System.out.println("ERRO: Caverna Inválida. Desligando... - COD DE ERRO: 002");
			return null;
		}
		
		else {
			return caverna;
		}
	}
	
	public void criarHeroi(Caverna caverna, int linha, int coluna) {
		Heroi novo = new Heroi(caverna, linha, coluna);
		this.nPlayers += 1;
		novo.conectar();
	}
	
	public void criarWumpus(Caverna caverna, int linha, int coluna) {
		Componente novo = new Wumpus(caverna, linha, coluna);
		this.nWumpus += 1;
		novo.conectar();
	}
	
	public void criarOuro(Caverna caverna, int linha, int coluna) {
		Componente novo = new Ouro(caverna, linha, coluna);
		this.nOuro += 1;
		novo.conectar();
	}
	
	public void criarBuraco(Caverna caverna, int linha, int coluna) {
		Componente novo = new Buraco(caverna, linha, coluna);
		this.nBuracos += 1;
		novo.conectar();
	}
	
	public void criarVazio(Caverna caverna, int linha, int coluna) {
		Componente novo = new Vazio(caverna, linha, coluna);
		novo.conectar();
	}
	
	public boolean verificarPosHeroi(int linha, int coluna) {
		boolean isValido = false;
		if (linha == 0 && coluna == 0) {
			isValido = true;
		}
		
		return isValido;
	}
	
	public boolean veriricarCaverna() {
		boolean isValido = true;
		
		if (nPlayers != 1) {
			isValido = false;
		}
		
		if (nBuracos > 3 || nBuracos < 2) {
			isValido = false;
		}
		
		if (nWumpus != 1) {
			isValido = false;
		}
		
		if (nOuro != 1) {
			isValido = false;
		}
		
		return isValido;
	}
}
