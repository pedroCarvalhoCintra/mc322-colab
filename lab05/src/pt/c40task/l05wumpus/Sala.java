package pt.c40task.l05wumpus;

public class Sala {
	private int nComponentes;
	private Componente[] componentes;
	private boolean foiVisitado;
	
	public Sala() {
		nComponentes = 0;
		componentes = new Componente[10]; //Componentes suficientes para todos os componentes possiveis.
		foiVisitado = false;
	}

	public Componente[] getComponentes() {
		return this.componentes;
	}
	
	public boolean getVisitado() {
		return this.foiVisitado;
	}
	
	public void setVisitado() {
		this.foiVisitado = true;
	}
	
	public boolean addComponente(Componente novo) {
		if (nComponentes != 0) {
			if (this.getMaiorPrioridade().getPrioridade() == 3 && novo.getPrioridade() == 3) {
				return false; //erro. Apenas 1 objeto de prioridade 3 (ouro, wumpus ou buraco) pode estar na mesma sala
			}
			
			else {
				if (novo.getId() == 'P') {
					this.setVisitado();
				}
				this.componentes[nComponentes] = novo;
				this.nComponentes += 1;
				return true;
			}
		}
		
		else {
			if (novo.getId() == 'P') {
				this.setVisitado();
			}
			this.componentes[nComponentes] = novo;
			this.nComponentes += 1;
			return true;
		}	
	}
	
	public void removerComponente(Componente removido) {
		for (int i = 0; i < nComponentes && componentes[i] != null; i++) {
			if (componentes[i].getId() == removido.getId()) {
				componentes[i] = componentes[nComponentes-1];
				componentes[nComponentes] = null;
				nComponentes -= 1;
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
	
	public Componente buscarId(char id) {
		Componente desejado = null;;
		for (int i = 0; i < nComponentes; i++) {
			if (componentes[i].getId() == id) {
				desejado = componentes[i];
			}
		}
		
		return desejado;
	}
	
}
