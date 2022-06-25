package com.projeto.game.controller.construtor;

import com.projeto.game.model.construcao.Escola;
import com.projeto.game.model.construcao.Hospital;
import com.projeto.game.model.construcao.Industria;
import com.projeto.game.model.construcao.Mercado;
import com.projeto.game.model.construcao.Moradia;
import com.projeto.game.model.construcao.Prefeitura;
import com.projeto.game.model.construcao.Vazio;

public interface IBuildConstrucao {
	public Escola buildEscola(int linha, int coluna);
	public Hospital buildHospital(int linha, int coluna);
	public Industria buildIndustria(int linha, int coluna);
	public Mercado buildMercado(int linha, int coluna);
	public Moradia buildMoradia(int linha, int coluna);
	public Prefeitura buildPrefeitura(int linha, int coluna);
	public Vazio buildVazio(int linha, int coluna);
}
