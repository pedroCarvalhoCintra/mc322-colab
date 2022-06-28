package com.projeto.game.model.cidade;

import com.projeto.game.model.populacao.IPopulacao;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.projeto.game.controller.controle.exception.ConstrucaoInvalida;
import com.projeto.game.controller.controle.exception.DinheiroInsuficiente;
import com.projeto.game.controller.controle.exception.PrefeituraInvalida;
import com.projeto.game.model.construcao.IConstrucao;

public class Cidade implements ICidade {
	final static private Texture ICONE_DINHEIRO = new Texture(Gdx.files.internal("Sprites/icon_money_2.png"));
	
	private static ICidade instancia;
    private IConstrucao[][] layout;
    private IPopulacao populacao;
    private float dinheiro;
    private float renda;
    private boolean prefeituraConstruida = false;
    
    private Label textoDinheiro;
    
    public Cidade(){
        
    }

    public float getDinheiro() {
    	return dinheiro;
    }

	public IConstrucao[][] getLayout() {
		return layout;
	}

	public void setLayout(IConstrucao[][] layout) {
		this.layout = layout;
	}

	public IPopulacao getPopulacao() {
		return populacao;
	}

	public void connectPopulacao(IPopulacao populacao) {
		this.populacao = populacao;
	}

	public void setDinheiro(float dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	public Table criarCidadeVisual() {
		Table tabela = new Table();
		tabela.setSize(900, 900);
		return tabela;
	}
	
	public void setLabel(Label label) {
		this.textoDinheiro = label;
	}

	public Label getLabel() {
		return this.textoDinheiro;
	}
	
	public float getRenda() {
		float renda = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				renda += layout[i][j].getRenda();
			}
		}
		
		renda += populacao.getRendaPopulacao();
		
		return renda;
	}

	public int numMoradiasVizinhas(IConstrucao construcao){
		int numMoradiasVizinhas = 0;

		for(int i = construcao.getLinha()-1; i <= construcao.getLinha()+1; i++ ){
			for(int j = construcao.getColuna()-1; j <= construcao.getColuna()+1; j++ ){
				if(i <= 9 && i >= 0 && j <= 9 && j >= 0) {
					if(layout[i][j].getTipo().equals("Household")){
						numMoradiasVizinhas++;
					}
				}
			}
		}
		return numMoradiasVizinhas;
	}
	
    public void interacoesMoradiaConstruiu(IConstrucao construcao){
        int numMoradiasVizinhas = numMoradiasVizinhas(construcao);
		String tipoConstrucao = construcao.getTipo();

		switch (tipoConstrucao) {
			case "Household":
				populacao.addSatisfacao(numMoradiasVizinhas* construcao.getSatisfacao());		
				break;
			case "School":
				populacao.addSatisfacao(numMoradiasVizinhas* construcao.getSatisfacao());
				break;
			case "Hospital":
				populacao.addSatisfacao(numMoradiasVizinhas*10);
				break;
			case "Market":
				this.setRenda(this.renda + numMoradiasVizinhas * construcao.getRenda());
			default:
				break;
		}
    }
    
    public int acharDecrescimos(IConstrucao moradia){
        int numDecrescimos = 0;
        for (int i = moradia.getLinha() - 1; i <= moradia.getLinha()+1; i++){
            for (int j = moradia.getColuna() - 1; j <= moradia.getColuna()+1; j++){
            	if (i <= 9 && i >= 0 && j <= 9 && j >= 0) {
                    if(layout[i][j].getTipo().equals("Factory")){
                        numDecrescimos++;
                    }
            	}
            }
        }
        return numDecrescimos;
    }
    
	public void interacoesMoradiaPassouDia(){
        int numDecrescimos = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if (layout[i][j].getTipo().equals("Household")){
                    numDecrescimos = acharDecrescimos(layout[i][j]);
                    populacao.addSatisfacao(-numDecrescimos*1);
                }
                
                else if (layout[i][j].getTipo().equals("Market")) {
    				this.setRenda(this.renda + numMoradiasVizinhas(layout[i][j]) * layout[i][j].getRenda());
                }
            }
        }
    }
	
	public void setRenda(float renda) {
		this.renda = renda;
	}
	
	public Group criarDinheiroVisual() {
    	Group grupo = new Group();
    	Image icone = new Image(ICONE_DINHEIRO);
    	
    	String texto ="$" + String.valueOf(dinheiro) + "\n";
    	if (renda >= 0) {
    		texto += "+";
    	}
    	
    	texto += String.valueOf(renda);
    	
    	textoDinheiro.setText(texto);
    	
    	
    	icone.scaleBy(5);
    	textoDinheiro.setPosition(115, 50);
    	
    	grupo.addActor(icone);
    	grupo.addActor(textoDinheiro);
    	
    	return grupo;
	}
	
	public void passarDia() {
		this.renda = getRenda();
		interacoesMoradiaPassouDia();
		dinheiro += renda;
		populacao.addSatisfacao(Math.round(-populacao.getNumHabitantes() * 0.0025f));
	}
	
	public void adicionarConstrucao(IConstrucao construcao) {
		boolean estado = false;
		
		if (construcao.getTipo() == "Vazio" ) {
			estado = true;
			layout[construcao.getLinha()][construcao.getColuna()] = construcao;
			this.renda = getRenda();
			this.interacoesMoradiaConstruiu(construcao);

		}
	
		else if (dinheiro >= construcao.getPreco() && layout[construcao.getLinha()][construcao.getColuna()].getTipo() == "Vazio") {
			if (construcao.getTipo() == "Town Hall") {
				if (prefeituraConstruida == false) {
					prefeituraConstruida = true;
				}
				
				else {
					throw new PrefeituraInvalida();
				}
			}
			
			if (construcao.getTipo() == "Household") {
				populacao.addPopulacao(50);
			}
			
			estado = true;
			dinheiro -= construcao.getPreco();
			layout[construcao.getLinha()][construcao.getColuna()] = construcao;
			this.renda = getRenda();
			this.interacoesMoradiaConstruiu(construcao);
		}
		
		if (estado == false) {
			throw new DinheiroInsuficiente();
		}
	}
	
	public void removerConstrucao(int linha, int coluna) {
		boolean estado = false;
		
		if (layout[linha][coluna].getTipo() != "Vazio" && layout[linha][coluna] != null) {
			if (layout[linha][coluna].getTipo() == "Town Hall" && prefeituraConstruida == true) {
				prefeituraConstruida = false;
			}
			estado = true;
			
			if (layout[linha][coluna].getConstruido() == false) {
				dinheiro += layout[linha][coluna].getPreco();
			}
			
			populacao.addSatisfacao(-layout[linha][coluna].getSatisfacao()*numMoradiasVizinhas(layout[linha][coluna]));
			layout[linha][coluna] = null;
		}
		
		if (estado == false) {
			throw new ConstrucaoInvalida();
		}
	}

	public static ICidade getInstancia() {
		if (instancia == null) {
			instancia = new Cidade();
		}
		return instancia;
	}
}
