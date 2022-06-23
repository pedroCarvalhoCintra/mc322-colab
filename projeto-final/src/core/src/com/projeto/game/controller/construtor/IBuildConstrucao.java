package com.projeto.game.controller.construtor;

import com.projeto.game.model.construcao.Escola;
import com.projeto.game.model.construcao.Hospital;
import com.projeto.game.model.construcao.Industria;
import com.projeto.game.model.construcao.Mercado;
import com.projeto.game.model.construcao.Moradia;
import com.projeto.game.model.construcao.Prefeitura;
import com.projeto.game.model.construcao.Vazio;

public interface IBuildConstrucao {
	public Escola buildEscola();
	public Hospital buildHospital();
	public Industria buildIndustria();
	public Mercado buildMercado();
	public Moradia buildMoradia();
	public Prefeitura buildPrefeitura();
	public Vazio buildVazio();
}
