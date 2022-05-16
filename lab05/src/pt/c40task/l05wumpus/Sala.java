package pt.c40task.l05wumpus;

public class Sala {
	private int nComponentes;
	private Componente[] componentes;
	private boolean foiVisitado;
	
	public Sala() {
		nComponentes = 0;
		componentes = new Componente[4]; //1 componente e a sala vazia. Maximo de 3 outros componentes, independentemente da situacao, com as regras dadas.
		foiVisitado = false;
	}

	public Componente[] getComponentes() {
		return this.componentes;
	}
	
	public boolean getVisitado() {
		return this.foiVisitado;
	}
	
	public void toggleVisitado() {
		this.foiVisitado = !this.foiVisitado;
	}
	
	public void addComponente(Componente novo) {
		this.componentes[nComponentes] = novo;
		this.nComponentes += 1;
	}
	
	public void removerComponente(Componente removido) {
		for (int i = 0; i < nComponentes && componentes[i] != null; i++) {
			if (componentes[nComponentes] == removido) {
				componentes[i] = componentes[nComponentes-1];
				componentes[nComponentes] = null;
				break;
			}
		}
	}
	
	public Componente getMaiorPrioridade() {
		Componente max = componentes[0];
		
		for (int i = 1; i < nComponentes; i++) {
			if (max.getPrioridade() < componentes[i].getPrioridade()) {
				max = componentes[i];
			}
		}
		
		return max;
	}
}
