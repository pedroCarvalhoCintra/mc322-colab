package com.projeto.game.controller.construtor;

import com.projeto.game.model.construcao.Escola;
import com.projeto.game.model.construcao.Hospital;
import com.projeto.game.model.construcao.Industria;
import com.projeto.game.model.construcao.Mercado;
import com.projeto.game.model.construcao.Moradia;
import com.projeto.game.model.construcao.Prefeitura;
import com.projeto.game.model.construcao.Vazio;

public class ConstrutorConstrucao implements IBuildConstrucao{
	
	private static IBuildConstrucao instancia;
	
	private ConstrutorConstrucao() {
		
	}
	
	public Escola buildEscola(int linha, int coluna) {
		Escola escola = new  Escola();
		escola.setLinha(linha);
		escola.setColuna(coluna);
		escola.setConstruido(true);
		return escola;
	}
		
	public Hospital buildHospital(int linha, int coluna) {
		Hostpital hostpital = new  Hostpital();
		hostpital.setLinha(linha);
		hostpital.setColuna(coluna);
		hostpital.setConstruido(true);
		return hostpital;
	}
	
	public Industria buildIndustria(int linha, int coluna) {
		Industria industria = new  Industria();
		industria.setLinha(linha);
		industria.setColuna(coluna);
		industria.setConstruido(true);
		return industria;
	}
	
	public Mercado buildMercado(int linha, int coluna) {
		Mercado mercador = new Mercado();
		mercador.setLinha(linha);
		mercador.setColuna(coluna);
		mercador.setConstruido(true);
		return mercador;
	}
	
	public Moradia buildMoradia(int linha, int coluna) {
		Moradia moradia = new Moradia();
		moradia.setLinha(linha);
		moradia.setColuna(coluna);
		moradia.setConstruido(true);
		return moradia;
	}
	
	public Prefeitura buildPrefeitura(int linha, int coluna) {
		Prefeitura prefeitura = new Prefeitura();
		prefeitura.setLinha(linha);
		prefeitura.setColuna(coluna);
		prefeitura.setConstruido(true);
		return prefeitura;
	}
	
	public Vazio buildVazio(int linha, int coluna) {
		Vazio vazio = new Vazio();
		vazio.setLinha(linha);
		vazio.setColuna(coluna);
		vazio.setConstruido(true);
		return vazio;
	}
	
	public static IBuildConstrucao getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorConstrucao();
		}
		return instancia;
	} 
	
}
