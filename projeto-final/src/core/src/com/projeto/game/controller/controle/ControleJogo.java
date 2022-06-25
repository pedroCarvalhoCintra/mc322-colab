package com.projeto.game.controller.controle;

package com.projeto.game.controller.construtor.IFactoryConstrutor;
package com.projeto.game.controller.construtor.FactoryConstrutor;
package com.projeto.game.model.calendario.ICalendario;
package com.projeto.game.model.gerador.IFactoryGeradorDeEventos;
package com.projeto.game.model.cidade.ICidade;

public class ControleJogo {

    private IControleJogo instancia;
    private IFactoryConstrutor construtor;
    private IFactoryGeradorDeEventos geradorDeEventos;
    private ICidade cidade;
    private ICalendario calendario;



    private ControleJogo(){

    }

    public void criarAtores(){
        construtor = FactoryConstrutor.getInstancia();
        geradorDeEventos = construtor.criarGeradorDeEventos();
        cidade = construtor.criarCidade();
        calendario = construtor.criarCalendario();
    }



    public static IControleJogo getInstancia() {
		if ( instancia == null ) {
			instancia = new ControleJogo();
		}
		return instancia;
	}
}