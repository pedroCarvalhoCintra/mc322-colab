package pt.c40task.l05wumpus;

import java.util.Scanner;

public class Controle {
	private Toolkit tk;
	private Caverna caverna;
    private Heroi player;
	private int score;
	private char status;
	private String nomeJogador;
	private boolean estaNoJogo; 

    public Controle(Toolkit tk, Caverna caverna){
		this.tk = tk;
        this.caverna = caverna;
		this.player = caverna.getHeroi();
		this.score = 0;
		this.status = 'x';
		this.nomeJogador = "Alcebiades";
		this.estaNoJogo = true;
    }

	public void setNomeJogador(String novoNome){
		this.nomeJogador = novoNome;
	}
	
	public void addScore(int score) {
		this.score += score;
	}

	public void perdeu(){
		status = 'n';
		this.addScore(-1000);
		tk.writeBoard(caverna.getCaverna(), score, status);
		
		System.out.println("\n");
		caverna.imprimirCaverna();
		System.out.println("Player: " + nomeJogador);
		System.out.println("Score: " + score);
		System.out.println("Voce perdeu =( ...");

		estaNoJogo = false;
	}

	public void ganhou(){
		status = 'w';
		this.addScore(1000);
		tk.writeBoard(caverna.getCaverna(), score, status);
		
		System.out.println("\n");
		caverna.imprimirCaverna();
		System.out.println("Player: " + nomeJogador);
		System.out.println("Score: " + score);
		System.out.println("Voce ganhou =) !!!");

		estaNoJogo = false;
	}

	public void intermediaria(){
		tk.writeBoard(caverna.getCaverna(), score, status);

		System.out.println("\n");
		caverna.imprimirCaverna();
		System.out.println("Player: " + nomeJogador);
		System.out.println("Score: " + score);
		System.out.println("Continue a jogar, continue a jogar, jogar, jogar ...");
	}

	public void sairJogo(){
		tk.writeBoard(caverna.getCaverna(), score, status);

		System.out.println("\n");
		caverna.imprimirCaverna();
		System.out.println("Player: " + nomeJogador);
		System.out.println("Score: " + score);
		System.out.println("Volte sempre !");
		
		estaNoJogo = false;
	}

	public boolean ehBuraco(Componente comp){
		boolean result = false;
		if (comp != null) {
			if (comp.getId() == 'B') 
				result = true;
		}
		return result;
	}

	public boolean ehOrigem(){
		boolean result = false;
		if ( player.getLinha() == 0 && player.getColuna() == 0 )
			result = true;
		return result;
	}

	public boolean ehWumpus(Componente comp){
		boolean result = false;
		if (comp != null) {
			if (comp.getId() == 'W') 
				result = true;
		}
		return result;
	}

	public boolean atirarFlecha(){
		return player.atirarFlecha();
	}

	public void confereMovimento(){
		if (player.getFlechaEquipada()) {
			boolean acerto = atirarFlecha();
			this.addScore(-100);
			if (ehWumpus(caverna.getSala(player.getLinha(), player.getColuna()).buscarId('W'))) {
				if (acerto == true) {
					player.matarWumpus();
					this.addScore(500);
				}
				
				else {
					perdeu();

				}
			}
		}
		
		if (ehBuraco(caverna.getSala(player.getLinha(), player.getColuna()).buscarId('B')))
			perdeu();
		else if ( ehOrigem() && player.getPegouOuro() ) {
			ganhou();
		} else {
			intermediaria();
		}
	}
	
    public void moverParaCima(){
    	if (this.caverna.verificarPosicao(player.getLinha()-1, player.getColuna())) {
    		player.desconectar();
            player.setLinha(player.getLinha()-1);
            player.conectar();
    		this.addScore(-15);
    	}
    	confereMovimento();
    }

    public void moverParaBaixo(){
    	if (this.caverna.verificarPosicao(player.getLinha()+1, player.getColuna())) {
    		player.desconectar();
            player.setLinha(player.getLinha()+1);
            player.conectar();
    		this.addScore(-15);
    	}
		confereMovimento();
    }

    public void moverParaDireita(){
    	if (this.caverna.verificarPosicao(player.getLinha(), player.getColuna()+1)) {
    		player.desconectar();
            player.setColuna(player.getColuna()+1);
            player.conectar();
    		this.addScore(-15);
    	}
		confereMovimento();
    }

    public void moverParaEsquerda(){
    	if (this.caverna.verificarPosicao(player.getLinha()-1, player.getColuna()-1)) {
    		player.desconectar();
            player.setColuna(player.getColuna()-1);
            player.conectar();
    		this.addScore(-15);
    	}
		confereMovimento();
    }

    public void equiparFlecha(){
        player.equiparFlecha();
		intermediaria();
    }

    public void capturarOuro(){
        player.capturarOuro();
		intermediaria();
    }



    public void iniciarLeitura(){
		String movimentos = tk.retrieveMovements();
		
		intermediaria();

        for ( int i = 0; i < movimentos.length() && estaNoJogo; i++ ){
            String movimento = movimentos.substring(i,i+1);
            switch(movimento){
                case "w":
                    moverParaCima();
                    break;
                case "s":
                    moverParaBaixo();
                    break;
                case "d":
                    moverParaDireita();
                    break;
                case "a":
                    moverParaEsquerda();
                    break;
                case "k":
                    equiparFlecha();
                    break;
                case "c":
                    capturarOuro();
                    break;
                case "q":
					sairJogo();
					break;
            }
        }
    }

    public void iniciarInterativo(){
        Scanner teclado = new Scanner(System.in);
		setNomeJogador(teclado.nextLine());
		intermediaria();

        String movimento = teclado.nextLine();

        while( estaNoJogo ){
            
            switch(movimento){
                case "w":
                    moverParaCima();
                    break;
                case "s":
                    moverParaBaixo();
                    break;
                case "d":
                    moverParaDireita();
                    break;
                case "a":
                    moverParaEsquerda();
                    break;
                case "k":
                    equiparFlecha();
                    break;
                case "c":
                    capturarOuro();
                    break;
				case "q":
					sairJogo();
					teclado.close();
					break;
				default:
					System.out.println("Inválido! Por favor, digite novamente.");
					break;
            }
		
			movimento = teclado.nextLine();
        }
		teclado.close();
    }

}