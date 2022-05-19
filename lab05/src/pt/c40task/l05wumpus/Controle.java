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
	private boolean matouWumpus;

    public Controle(Toolkit tk, Caverna caverna){
		this.tk = tk;
        this.caverna = caverna;
		this.player = caverna.getHeroi();
		this.score = 0;
		this.status = 'x';
		this.nomeJogador = "Alcebiades";
		this.estaNoJogo = true;
		this.matouWumpus = false;
    }

	public void setNomeJogador(String novoNome){
		this.nomeJogador = novoNome;
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	
	public void imprimirEstado() {
		caverna.imprimirCaverna();
		System.out.println("Player: " + nomeJogador);
		System.out.println("Score: " + score);
		
		if (matouWumpus == true) {
			System.out.println("Matou Wumpus: Sim");
		}
		
		else {
			System.out.println("Matou Wumpus: Nao");
		}
		
		if (player.getPegouOuro()) {
			System.out.println("Pegou Ouro: Sim");
		}
		
		else {
			System.out.println("Pegou Ouro: Nao");
		}
	}
	
	public void mensagemMorte(char causa) {
		switch(causa) {
		case 'w':
			System.out.println("Causa da Morte: O Wumpus teve um otimo jantar hoje. Prepare-se melhor na proxima!");
			break;
		case 'b':
			System.out.println("Causa da Morte: Testou a teoria gravitacional. Olhe melhor por onde pisa!");
			break;
		case 'c':
			System.out.println("Causa da Morte: Mirou alto demais. Treine melhor sua pontaria!");
			break;
		}
	}
	
	public void perdeu(char motivo){
		status = 'n';
		this.addScore(-1000);
		tk.writeBoard(caverna.getCaverna(), score, status);
		
		imprimirEstado();
		
		System.out.println("Oh Nao! Voce perdeu! Espero que tenha melhor sorte da proxima vez!");
		mensagemMorte(motivo);

		estaNoJogo = false;
	}

	public void ganhou(){
		status = 'w';
		this.addScore(1000);
		tk.writeBoard(caverna.getCaverna(), score, status);
		
		imprimirEstado();

		System.out.println("Vitoria! O heroi conquistou seu o seu objetivo e vai viver uma vida pacata ate que o ouro acabe! Nos vemos em Valhalla!");

		estaNoJogo = false;
	}

	public void intermediaria(){
		tk.writeBoard(caverna.getCaverna(), score, status);
		
		imprimirEstado();
		vasculharCaverna();
		System.out.println("Continue jogando!");
	}

	public void sairJogo(){
		tk.writeBoard(caverna.getCaverna(), score, status);

		imprimirEstado();

		System.out.println("Saiu do Jogo! Volte sempre!");
		
		estaNoJogo = false;
	}
	
	public void matarWumpus(int linha, int coluna){
		Componente Wumpus = caverna.getSala(linha, coluna).buscarId('W');
        if (Wumpus != null)
			Wumpus.desconectar();
			this.addScore(500);
        	this.matouWumpus = true;
	}
	
	public boolean capturarOuro(int linha, int coluna){
		Componente componenteBuscado = caverna.getSala(linha, coluna).buscarId('O');
		boolean pegou = false;
        if (componenteBuscado != null){
            componenteBuscado.desconectar();
            player.setPegouOuro(true);
            pegou = true;
		}
        
        return pegou;
	}
	
	public boolean ehOrigem(){
		boolean result = false;
		if (player.getLinha() == 0 && player.getColuna() == 0)
			result = true;
		return result;
	}

	public boolean ehBuraco(Componente comp){
		boolean result = false;
		if (comp != null) {
			if (comp.getId() == 'B') 
				result = true;
		}
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
	
	public boolean ehOuro(Componente comp) {
		boolean result = false;
		if (comp != null) {
			if (comp.getId() == 'O') 
				result = true;
		}
		return result;
	}
	
	public boolean ehBrisa(Componente comp) {
		boolean result = false;
		if (comp != null) {
			if (comp.getId() == 'b') 
				result = true;
		}
		return result;
	}
	
	public boolean ehFedor(Componente comp) {
		boolean result = false;
		if (comp != null) {
			if (comp.getId() == 'f') 
				result = true;
		}
		return result;
	}

	public boolean atirarFlecha(){
		return player.atirarFlecha();
	}
	
	public void vasculharCaverna() {
		int linha = player.getLinha();
		int coluna = player.getColuna();
		
		boolean ehFedor = ehFedor(caverna.getSala(linha, coluna).buscarId('f'));
		boolean ehBrisa = ehBrisa(caverna.getSala(linha, coluna).buscarId('b'));
		boolean ehOuro = ehOuro(caverna.getSala(linha, coluna).buscarId('O'));
		
		if (ehFedor) {
			System.out.println("> Voce sente um odor terrrvel!");
		}
		
		if (ehBrisa) {
			System.out.println("> Vocr sente uma leve brisa....");
		}
		
		if (ehOuro) {
			System.out.println("> Vocr vr um brilho dourado!");
		}
	}

	public void confereMovimento(){
		int linha = player.getLinha();
		int coluna = player.getColuna();
		
		boolean ehBuraco = ehBuraco(caverna.getSala(linha, coluna).buscarId('B'));
		boolean ehWumpus = ehWumpus(caverna.getSala(linha, coluna).buscarId('W'));
		boolean ehOrigem = ehOrigem();
		
		if (player.getFlechaEquipada()) {
			boolean acerto = atirarFlecha();
			this.addScore(-100);
			if (ehWumpus) {
				ehWumpus = false;
				if (acerto == true) {
					matarWumpus(linha, coluna);
				}
				else {
					perdeu('c');
				}
			}
		}
		
		if (ehBuraco) {
			perdeu('b');
		}
		
		else if (ehWumpus) {
			perdeu('w');
		}
		
		else if (ehOrigem && player.getPegouOuro()) {
			ganhou();
		}
		
		else if (estaNoJogo){
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
    	
    	else {
    		System.out.println("ERRO: Tentou sair da caverna. Nada foi alterado - COD: 003");
    	}
		confereMovimento();
    }

    public void moverParaEsquerda(){
    	if (this.caverna.verificarPosicao(player.getLinha(), player.getColuna()-1)) {
    		player.desconectar();
            player.setColuna(player.getColuna()-1);
            player.conectar();
    		this.addScore(-15);
    	}
		confereMovimento();
    }

    public void equiparFlecha(){
        boolean equipou = player.equiparFlecha();
        
		intermediaria();
		
		if (equipou == true) {
        	System.out.println(">> Flecha equipada!");
    	}
            
        else {
        	System.out.println(">> Nao ha mais flechas!");
        }
    }

    public void capturarOuro(){
        boolean pegou = capturarOuro(player.getLinha(), player.getColuna());
        
        intermediaria();
        
        if (pegou == true) {
        	System.out.println("* Ouro capturado! *");
    	}
            
        else {
        	System.out.println("Ouro? Acho que voce se confundiu...");
        }
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

        while(estaNoJogo){
            
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
				default:
					System.out.println("Invalido! Por favor, digite novamente.");
					break;
            }
            if (estaNoJogo) {
    			movimento = teclado.nextLine();
            }
        }
		teclado.close();
    }

}