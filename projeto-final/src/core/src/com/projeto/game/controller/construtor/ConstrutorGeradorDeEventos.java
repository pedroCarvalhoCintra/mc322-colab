package com.projeto.game.controller.construtor;

package com.projeto.game.model.gerador.IFactoryGeradorDeEventos;
package com.projeto.game.model.gerador.FactoryGeradorDeEventos;

public class ConstrutorGeradorDeEventos implements IBuildGeradorDeEventos{
	
	private static IBuildGeradorDeEventos instancia;
	
	private ConstrutorGeradorDeEventos() {
		
	}
	
	public IFactoryGeradorDeEventos buildGeradorDeEventos() {
		IFactoryGeradorDeEventos geradorDeEventos =  FactoryGeradorDeEventos.getInstancia();
		return geradorDeEventos;
	}
	
	
	public static IBuildGeradorDeEventos getInstancia() {
		if ( instancia == null ) {
			instancia = new ConstrutorGeradorDeEventos();
		}
		return instancia;
	} 
	

}
