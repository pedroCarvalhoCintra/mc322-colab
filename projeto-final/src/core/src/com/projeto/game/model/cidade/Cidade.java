package com.projeto.game.model.cidade;

import com.projeto.game.model.populacao.IPopulacao;
import com.projeto.game.view.construcao.IViewConstrucao;
import com.projeto.game.view.construcao.ViewConstrucao;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.model.construcao.IConstrucao;

public class Cidade implements ICidade {

	private static ICidade instancia;
    private IConstrucao[][] layout;
    private IPopulacao populacao;
    private float dinheiro;
    
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
	
	public Table criarCidadeVisual(Stage stage, IFactoryGui factoryGui) {
		Table tabela = new Table();
		tabela.setSize(900, 900);
		
		for (int i = 0; i < 10; i ++) {
			for (int j = 0; j < 10; j ++) {
				IViewConstrucao construcao = new ViewConstrucao();
				construcao.connect(layout[i][j]);
				construcao.connectGui(factoryGui);
				tabela.add(construcao.getVisual()).expand();
				construcao.connectStage(stage);
			}
			tabela.row();
		}
		return tabela;
	}
	
	public boolean adicionarConstrucao(IConstrucao construcao) {
		boolean estado = false;
		
		if (construcao.getTipo() == "Vazio" ) {
			estado = true;
			layout[construcao.getLinha()][construcao.getColuna()] = construcao;
		}
	
		else if (dinheiro >= construcao.getPreco() && layout[construcao.getLinha()][construcao.getColuna()].getTipo() == "Vazio") {
			estado = true;
			dinheiro -= construcao.getPreco();
			layout[construcao.getLinha()][construcao.getColuna()] = construcao;
		}
		
		return estado;
	}
	
	public boolean removerConstrucao(int linha, int coluna) {
		boolean estado = false;
		
		if (layout[linha][coluna].getTipo() != "Vazio" && layout[linha][coluna] != null) {
			estado = true;
			dinheiro += layout[linha][coluna].getPreco()/2;
			layout[linha][coluna] = null;
		}
		
		return estado;
	}

	public static ICidade getInstancia() {
		if ( instancia == null ) {
			instancia = new Cidade();
		}
		return instancia;
	}
}
