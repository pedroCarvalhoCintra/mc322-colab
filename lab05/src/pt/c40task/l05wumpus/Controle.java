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

	public void perdeu(){
		status = 'n';
		score -= 1000;
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
		score += 1000;
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
		if (comp.getId() == 'B') 
			result = true;
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
		if (comp.getId() == 'W') 
			result = true;
		return result;
	}

	public boolean atirarFlecha(){
		return player.atirarFlecha();
	}

	public void confereMovimento(){
		
		if ( ehBuraco(caverna.getSala(player.getLinha(), player.getColuna()).buscarId('B')))
			perdeu();
		else if ( ehOrigem() && player.getPegouOuro() )
			ganhou();
		else if ( ehWumpus(caverna.getSala(player.getLinha(), player.getColuna()).buscarId('W'))){
			if ( atirarFlecha() ){
				player.matarWumpus();
				score += 500;
			}
			else
				perdeu();
		} else {
			intermediaria();
		}
	}

    public void moverParaCima(){
        player.desconectar();
        player.setLinha(player.getLinha()-1);
        player.conectar();
		score -= 15;
		confereMovimento();
    }

    public void moverParaBaixo(){
        player.desconectar();
        player.setLinha(player.getLinha()+1);
        player.conectar();
		score -= 15;
		confereMovimento();
    }

    public void moverParaDireita(){
        player.desconectar();
        player.setColuna(player.getColuna()+1);
        player.conectar();
		score -= 15;
		confereMovimento();
    }

    public void moverParaEsquerda(){
        player.desconectar();
        player.setColuna(player.getColuna()-1);
        player.conectar();
		score -= 15;
		confereMovimento();
    }

    public void equiparFlecha(){
        player.equiparFlecha();
		score -= 100;
		intermediaria();
    }

    public void capturarOuro(){
        player.capturarOuro();
		intermediaria();
    }



    public void iniciarLeitura(){
		String movimentos = tk.retrieveMovements();

        for ( int i = 0; i < movimentos.length() && estaNoJogo; i++ ){
            String movimento = movimentos.substring(0,1);
            movimentos = movimentos.substring(1,movimentos.length());
            
            switch(movimento){
                case "w":
                    moverParaCima();
                case "s":
                    moverParaBaixo();
                case "d":
                    moverParaDireita();
                case "a":
                    moverParaEsquerda();
                case "k":
                    equiparFlecha();
                case "c":
                    capturarOuro();
                case "q":
					sairJogo();
            }
			
        
        }


    }

    public void iniciarInterativo(){
        Scanner teclado = new Scanner(System.in);
		setNomeJogador(teclado.nextLine());
        String movimento = teclado.nextLine();

        while( estaNoJogo ){
            
            switch(movimento){
                case "w":
                    moverParaCima();
                case "s":
                    moverParaBaixo();
                case "d":
                    moverParaDireita();
                case "a":
                    moverParaEsquerda();
                case "k":
                    equiparFlecha();
                case "c":
                    capturarOuro();
				case "q":
					sairJogo();
            }
		
			movimento = teclado.nextLine();
        }
		teclado.close();
    }


}
