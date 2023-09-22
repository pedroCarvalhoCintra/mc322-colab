package com.projeto.game.controller.construtor.construcoes;

import com.projeto.game.model.construcao.Escola;
import com.projeto.game.model.construcao.Hospital;
import com.projeto.game.model.construcao.Industria;
import com.projeto.game.model.construcao.Mercado;
import com.projeto.game.model.construcao.Moradia;
import com.projeto.game.model.construcao.Prefeitura;
import com.projeto.game.model.construcao.Vazio;

public class ConstrutorConstrucao implements IBuildConstrucao {
	
	private static IBuildConstrucao instancia;
	
	private ConstrutorConstrucao() {
		
	}
	
	public Escola buildEscola(int linha, int coluna) {
		Escola escola = new  Escola();
		escola.setLinha(linha);
		escola.setColuna(coluna);
		escola.setConstruido(false);
		return escola;
	}
		
	public Hospital buildHospital(int linha, int coluna) {
		Hospital hostpital = new  Hospital();
		hostpital.setLinha(linha);
		hostpital.setColuna(coluna);
		hostpital.setConstruido(false);
		return hostpital;
	}
	
	public Industria buildIndustria(int linha, int coluna) {
		Industria industria = new  Industria();
		industria.setLinha(linha);
		industria.setColuna(coluna);
		industria.setConstruido(false);
		return industria;
	}
	
	public Mercado buildMercado(int linha, int coluna) {
		Mercado mercado = new Mercado();
		mercado.setLinha(linha);
		mercado.setColuna(coluna);
		mercado.setConstruido(false);
		return mercado;
	}
	
	public Moradia buildMoradia(int linha, int coluna) {
		Moradia moradia = new Moradia();
		moradia.setLinha(linha);
		moradia.setColuna(coluna);
		moradia.setConstruido(false);
		return moradia;
	}
	
	public Prefeitura buildPrefeitura(int linha, int coluna) {
		Prefeitura prefeitura = new Prefeitura();
		prefeitura.setLinha(linha);
		prefeitura.setColuna(coluna);
		prefeitura.setConstruido(false);
		return prefeitura;
	}
	
	public Vazio buildVazio(int linha, int coluna) {
		Vazio vazio = new Vazio();
		vazio.setLinha(linha);
		vazio.setColuna(coluna);
		vazio.setConstruido(false);
		return vazio;
	}
	
	public static IBuildConstrucao getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorConstrucao();
		}
		return instancia;
	} 
	
}
