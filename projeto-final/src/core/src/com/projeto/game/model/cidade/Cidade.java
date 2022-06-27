package com.projeto.game.model.cidade;

import com.projeto.game.model.populacao.IPopulacao;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
				
			}
		}
		
		return renda;
	}

	public int numMoradiasVizinhas(IConstrucao construcao){
		int numMoradiasVizinhas = 0;

		for(int i = construcao.getLinha()-1; i <= construcao.getLinha()+1  && i <= 10 && i >= 0; i++ ){
			for(int j = construcao.getColuna()-1; j <= construcao.getColuna()+1 && j <= 10 && j >= 0; j++ ){
				if(layout.getTipo().equals("Moradia")){
					numMoradiasVizinhas++;
				}
			}
		}
		return numMoradiasVizinhas;
	}
	
    public void interacoesMoradiaConstruiu(IConstrucao moradia){
        int numMoradiasVizinhas = numMoradiasVizinhas(construcao);
		String tipoConstrucao = construcao.getTipo();

		switch (tipo) {
			case "moradia":
				Populacao.addSatisfacao(numMoradiasVizinhas*1);		
				break;
			case "Escola":
				Populacao.addSatisfacao(numAcrescimosEscola*5);
				break;
			case "Hospital":
				Populacao.addSatisfacao(numMoradiasVizinhas*10);
				break;
			default:
				break;
		}
    }
    
    public int acharDecrescimos(IConstrucao moradia){
        int numDecrescimos = 0;
        for ( int i = moradia.getLinha() - 1; i < moradia.getLinha() + 1 && i < 10; i++){
            for ( int j = moradia.getColuna() - 1; j < moradia.getColuna() + 1 && j < 10; j++){
                if(layout[i][j].getTipo().equals("Industria")){
                    numDecrescimos++;
                }
            }
        }
        return numDecrescimos;
    }

	public void interacoesMoradiaPassouDia(){
        int numDecrescimos = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if ( cidade.getLayout()[i][j].getTipo().equals("Moradia")){
                    numDecrescimos = acharDecrescimos(layout[i][j]);
                    Populacao.addSatisfacao(numDecrescimos*1);
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
    	
    	textoDinheiro.setText("$" + String.valueOf(dinheiro));
    	
    	
    	icone.scaleBy(5);
    	textoDinheiro.setPosition(115, 50);
    	
    	grupo.addActor(icone);
    	grupo.addActor(textoDinheiro);
    	
    	return grupo;
	}
	
	public void adicionarConstrucao(IConstrucao construcao) {
		boolean estado = false;
		
		if (construcao.getTipo() == "Vazio" ) {
			estado = true;
			layout[construcao.getLinha()][construcao.getColuna()] = construcao;
		}
	
		else if (dinheiro >= construcao.getPreco() && layout[construcao.getLinha()][construcao.getColuna()].getTipo() == "Vazio") {
			if (construcao.getTipo() == "Prefeitura") {
				if (prefeituraConstruida == false) {
					prefeituraConstruida = true;
				}
				
				else {
					throw new IllegalArgumentException();
				}
			}
			
			estado = true;
			dinheiro -= construcao.getPreco();
			layout[construcao.getLinha()][construcao.getColuna()] = construcao;
		}
		
		if (estado == false) {
			throw new NullPointerException();
		}
	}
	
	public void removerConstrucao(int linha, int coluna) {
		boolean estado = false;
		
		if (layout[linha][coluna].getTipo() != "Vazio" && layout[linha][coluna] != null) {
			if (layout[linha][coluna].getTipo() == "Prefeitura" && prefeituraConstruida == true) {
				prefeituraConstruida = false;
			}
			estado = true;
			dinheiro += layout[linha][coluna].getPreco()/2;
			layout[linha][coluna] = null;
		}
		
		if (estado == false) {
			throw new NullPointerException();
		}
	}

	public static ICidade getInstancia() {
		if ( instancia == null ) {
			instancia = new Cidade();
		}
		return instancia;
	}
}
