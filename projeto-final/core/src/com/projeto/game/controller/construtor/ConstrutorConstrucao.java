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
	
	public Escola buildEscola() {
		
	}
		
	public Hospital buildHospital() {
		
	}
	
	public Industria buildIndustria() {
		
	}
	
	public Mercado buildMercado() {
		
	}
	
	public Moradia buildMoradia() {
		
	}
	
	public Prefeitura buildPrefeitura() {
		
	}
	
	public Vazio buildVazio() {
		
	}
	
	public static IBuildConstrucao getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorConstrucao();
		}
		return instancia;
	} 
	
}
