package com.projeto.game.model.cidade;

import com.projeto.game.model.populacao.IPopulacao;
import com.projeto.game.view.construcao.IViewConstrucao;
import com.projeto.game.view.construcao.ViewConstrucao;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
	
	public Table criarCidadeVisual(Stage stage) {
		Table tabela = new Table();
		tabela.setSize(900, 900);
		
		for (int i = 0; i < 10; i ++) {
			for (int j = 0; j < 10; j ++) {
				IViewConstrucao construcao = new ViewConstrucao();
				construcao.connect(layout[i][j]);
				construcao.connectStage(stage);
				tabela.add(construcao.getVisual()).expand();
			}
			tabela.row();
		}
		
		return tabela;
	}

	public static ICidade getInstancia() {
		if ( instancia == null ) {
			instancia = new Cidade();
		}
		return instancia;
	}


}
