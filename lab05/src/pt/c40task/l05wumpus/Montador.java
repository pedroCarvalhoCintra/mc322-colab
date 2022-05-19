package pt.c40task.l05wumpus;

public class Montador {
	Heroi heroi;
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
					System.out.println("ERRO: Caverna Invalida: Jogador fora da posicao inicial. Desligando... - COD DE ERRO: 001");
					return null;
				}
				if (criarHeroi(caverna, linha, coluna) == false) {
					System.out.println("ERRO: Caverna Invalida. Sala verificou um problema na insercao de componente. Desligando... - COD DE ERRO: 002");
					return null;
				}
				
				break;
			case "W":
				if (criarWumpus(caverna, linha, coluna) == false) {
					System.out.println("ERRO: Caverna Invalida. Sala verificou um problema na insercao de componente. Desligando... - COD DE ERRO: 002");
					return null;
				}
				
				break;
			case "B":
				if (criarBuraco(caverna, linha, coluna) == false) {
					System.out.println("ERRO: Caverna Invalida. Sala verificou um problema na insercao de componente. Desligando... - COD DE ERRO: 002");
					return null;
				}
				break;
			case "O":
				if (criarOuro(caverna, linha, coluna) == false) {
					System.out.println("ERRO: Caverna Invalida. Sala verificou um problema na insercao de componente. Desligando... - COD DE ERRO: 002");
					return null;
				}
				break;
			case "_":
				if (criarVazio(caverna, linha, coluna) ==  false) {
					System.out.println("ERRO: Caverna Invalida. Sala verificou um problema na insercao de componente. Desligando... - COD DE ERRO: 002");
					return null;
				}
				break;	
			default:
				if (criarVazio(caverna, linha, coluna) == false) {
					System.out.println("ERRO: Caverna Invalida. Sala verificou um problema na insercao de componente. Desligando... - COD DE ERRO: 002");
					return null;
				}
				break;	
			}
			
			if (layout[i][2].equals("_") == false) {
				criarVazio(caverna, linha, coluna); //Sempre colocamos um componente vazio nas salas, para facilitar caso todos os outros componentes sejam removidos.
			}
		}
		
		
		if (veriricarCaverna() == false) {
			System.out.println("ERRO: Caverna Invalida. Desligando... - COD DE ERRO: 003");
			return null;
		}
		
		else {
			return caverna;
		}
	}
	
	public boolean criarHeroi(Caverna caverna, int linha, int coluna) {
		Heroi novo = new Heroi(caverna, linha, coluna);
		boolean resultado;
		this.nPlayers += 1;
		resultado = novo.conectar();
		if (resultado == true) {
			this.heroi = novo;
		}
		return resultado;
	}
	
	public boolean criarWumpus(Caverna caverna, int linha, int coluna) {
		Componente novo = new Wumpus(caverna, linha, coluna);
		boolean resultado;
		this.nWumpus += 1;
		resultado = novo.conectar();
		return resultado;
	}
	
	public boolean criarOuro(Caverna caverna, int linha, int coluna) {
		Componente novo = new Ouro(caverna, linha, coluna);
		boolean resultado;
		this.nOuro += 1;
		resultado = novo.conectar();
		return resultado;
	}
	
	public boolean criarBuraco(Caverna caverna, int linha, int coluna) {
		Componente novo = new Buraco(caverna, linha, coluna);
		boolean resultado;
		this.nBuracos += 1;
		resultado = novo.conectar();
		return resultado;
	}
	
	public boolean criarVazio(Caverna caverna, int linha, int coluna) {
		Componente novo = new Vazio(caverna, linha, coluna);
		boolean resultado;
		resultado = novo.conectar();
		return resultado;
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
	
	public Heroi getHeroi() {
		return this.heroi;
	}
}
