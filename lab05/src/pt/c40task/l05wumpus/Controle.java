package pt.c40task.l05wumpus;

import java.util.Scanner;

public class Controle {
	private Toolkit tk;
	private Caverna caverna;
    private Heroi player;
	private int score;
	private char status;
	private String nomeJodador;
	private boolean estaNoJogo; 

    public Controle(Toolkit tk, Caverna caverna){
		this.tk = tk;
        this.caverna = caverna;
		this.player = caverna.getSala(0,0).getMaiorPrioridade();
		this.score = 0;
		this.status = 'x';
		this.jodador = "Alcebiades";
		this.estaNoJogo = true;
    }

	public void setNomeJogador(String novoNome){
		this.nomeJodador = novoNome;
	}

	public void perdeu(){
		status = 'n';
		score -= 1000;
		tk.writeBoard(caverna.getCaverna(), score, status);
		
		System.out.println("\n");
		caverna.imprimirCaverna();
		System.out.println("Player: " + nomeJodador);
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
		System.out.println("Player: " + nomeJodador);
		System.out.println("Score: " + score);
		System.out.println("Voce ganhou =) !!!");

		estaNoJogo = false;
	}

	public void intermediaria(){
		tk.writeBoard(caverna.getCaverna(), score, status);

		System.out.println("\n");
		caverna.imprimirCaverna();
		System.out.println("Player: " + nomeJodador);
		System.out.println("Score: " + score);
		System.out.println("Continue a jogar, continue a jogar, jogar, jogar ...");
	}

	public void sairJogo(){
		tk.writeBoard(caverna.getCaverna(), score, status);

		System.out.println("\n");
		caverna.imprimirCaverna();
		System.out.println("Player: " + nomeJodador);
		System.out.println("Score: " + score);
		System.out.println("Volte sempre !");
	}

	public boolean ehBuraco(String idComponente){
		boolean result = false;
		if ( idComponente.equals("B") ) 
			result = true;
		return result;
	}

	public ehOrigem(){
		boolean result = false;
		if ( player.getLinha() == 0 && player.getColuna() == 0 )
			result = true;
		return result;
	}

	public boolean ehWumpus(String idComponente){
		boolean result = false;
		if ( idComponente.equals("B") ) 
			result = true;
		return result;
	}

	public boolean atirarFlecha(){
		return player.atiraFlecha();
	}

	public void confereMovimento(){
		
		if ( ehBuraco(caverna.getSala(player.getLinha(), player.getColuna()).buscarID("B")) != null )
			perdeu();
		else if ( ehOrigem() && player.getPegouOuro() )
			ganhou();
		else if ( ehWumpus(caverna.getSala(player.getLinha(), player.getColuna()).buscarID("W")) != null ){
			if ( atiraFlecha() ){
				player.mataWumpus();
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
		intermediaria()
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
                    equipaFlecha();
                case "c":
                    capturaOuro();
                case "q":
					sairJogo();
            }
			
        
        }


    }

    public void iniciarInterativo(){
        Scanner teclado = new Scanner(System.in);
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
                    equipaFlecha();
                case "c":
                    capturaOuro();
				case "q":
					sairJogo();
            }
        }
    }

}
