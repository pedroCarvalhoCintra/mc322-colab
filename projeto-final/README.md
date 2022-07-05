# Projeto `Untitled City Game`.

# Descrição
O `<Título do Jogo>` é um jogo de construção de cidades em que o jogador deve assumir o papel de um prefeito e organizar sua cidade de modo a fazer com que ela prospere e que sua população fique satisfeita. Portanto, o jogo tem como próposito fazer com o que o jogador entenda como planejar de maneira eficiente e criativa o arranjo de construções da cidade fazendo com que ela progrida de acordo com as regras de jogo. 

# Equipe
* `Riccardo Carvalho Sofer - RA 247362`
* `Pedro Carvalho Cintra - RA 247315`

# Arquivo executável do jogo

[jar](src/desktop/build/libs)

# Slides do projeto
[Link Slides](https://docs.google.com/presentation/d/1TJfkO0ycISbAXsCrqyaSoHrUhCPaGAkyrBRW4GFfrWY/edit?usp=sharing)

# Diagramas
## Diagrama geral de Arquitetura do Jogo

* teste image

![Diagrama](assets4documentation/arquitetura-geral-projeto.png)

## Diagrama geral de Componentes  


## Componente `Cidade`
Componente que contem o layout de construcoes 



**Ficha Técnica**
item | detalhamento
----- | -----
Classe | Cidade: `com.projeto.game.model.cidade`
Autores | Riccardo Carvalho Sofer e Pedro Carvalho Cintra
Interfaces | `ICidade, ICidadeVisual, IRPopulacao, ICidadeProperties, IModificarCidade, ICidadeDinamica `

### interfaces 
> interfaces associadas a esse componente

> interface agregador do componente em java
~~~java
public interface ICidade extends ICidadeVisual, IRPopulacao, ICidadeProperties, IModificarCidade, ICidadeDinamica {
}
~~~


### Detalhamento das interfaces

#### Interface `ICidadeVisual`
Interface responsável pela criação visual da cidade e do dinheiro.

~~~java
package com.projeto.game.model.cidade;
…
public interface ICidadeVisual {
	public Table criarCidadeVisual();
	public Group criarDinheiroVisual();
}
~~~

Método | Objetivo
-------| --------
`criarCidadeVisual` | método que cria uma Table, configura suas dimensões e a retorna.
`criarDinheiroVisual` | método que cria um Group que contém o ícone e o texto referentes ao dinheiro e o retorna.




#### Interface `IRPopulacao`
Interface responsável por conectar populacao na cidade.

~~~java
package com.projeto.game.model.cidade;
…
public interface IRPopulacao {
    public void connectPopulacao(IPopulacao populacao);
}
~~~

Método | Objetivo
-------| --------
`connectPopulacao` | método que recebe a interface IPopulacao como parâmetro e a conecta com a cidade.






#### Interface `ICidadeProperties`
Interface responsável pelos métodos relacionados as propriedades da cidade.

~~~java

package com.projeto.game.model.cidade;
…
public interface ICidadeProperties {
	public float getDinheiro();
	public IConstrucao[][] getLayout();
	public void setLayout(IConstrucao[][] layout);
	public IPopulacao getPopulacao();
	public void setDinheiro(float dinheiro);
	public void setLabel(Label label);
	public Label getLabel();
	public float getRenda();
	public void setRenda(float renda);
}
~~~

Método | Objetivo
-------| --------
`getDinheiro` | método que retorna o dinheiro da cidade.
`getLayout` | método que retorna o layout da cidade.
`setLayout` | método que recebe como parâmetro uma matriz de IConstrucao e a defini no atributo layout da cidade.
`getPopulacao` | método que retorna a populacao da cidade.
`setDinheiro` | método que recebe como parâmetro um float e o defini no atributo dinheiro da cidade.
`setLabel` | método que recbe como parâmetro um Label e o defini no atributo label da cidade.
`getLabel` | método que retorna o label da cidade.
`getRenda` | método que retorna a renda da cidade.
`setRenda` | método que recebe como parâmetro um float e o defini no atributo renda da cidade.





#### Interface `IModificarCidade`
Interface responsável pela adição e remoção de construcao na cidade.

~~~java
package com.projeto.game.model.cidade;
…
public interface IModificarCidade {
	public void adicionarConstrucao(IConstrucao construcao);
	public void removerConstrucao(int linha, int coluna);
}
~~~

Método | Objetivo
-------| --------
`adicionaConstrucao` | método que realiza a construção de uma nova construcao na cidade, realizando as alterações necessárias na cidade.
`removerConstrucao` | método que realiza a demolição de uma construcao na cidade, realizando as alterações necessárias na cidade.





#### Interface `ICidadeDinamica`
Interface responsável pelas interações com a cidade, como .

~~~java
package com.projeto.game.model.cidade;
…
public interface ICidadeDinamica {
	public int numMoradiasVizinhas(IConstrucao construcao);
	public void interacoesMoradiaConstruiu(IConstrucao construcao);
	public int acharDecrescimos(IConstrucao moradia);
	public void interacoesMoradiaPassouDia();
	public void passarDia();
}
~~~

Método | Objetivo
-------| --------
`numMoradiasVizinhas` | método que recebe como parâmetro uma IConstrucao e retorna a quantidade de construções do tipo Moradia ao redor.
`interacoesMoradiaConstruiu` | método que realiza a interação, nesse caso a possível adição de satisfacao da populacao,apos uma construcao ser construída.
`acharDecrescimos` | método que recebe como parâmetro uma IConstrucao do tipo Moradia e retorna a quantidade de decrèscimos, nesse caso a quantidade de construções do tipo Industria.
`interacoesMoradiaPassouDia` | método que passa por todas as contruções do tipo Moradia e realiza os decrésimos de satisfacao da populacao.
`passarDia` | método que realiza os efeitos na cidade ao passar o dia.






## Componente `construcao`
Componente que



**Ficha Técnica**
item | detalhamento
----- | -----
Classe | Construcao: `com.projeto.game.model.construcao`
Subclasses (Construcao) | Escola, Moradia, Mercado, Industria, Prefeitura, Hospital e Vazio 
Autores | Riccardo Carvalho Sofer e Pedro Carvalho Cintra
Interfaces | `IConstrucao, IConstrucaoProperties, IConstrucaoVisual`

### interfaces 
> interfaces associadas a esse componente

> interface agregador do componente em java
~~~java
package com.projeto.game.model.construcao;

public interface IConstrucao extends IConstrucaoProperties, IConstrucaoVisual {
}
~~~

### Detalhamento das interfaces

#### Interface `IConstrucaoProperties`
Interface responsável pelos métodos relacionados as propriedades da construcao.

~~~java
package com.projeto.game.model.construcao;
…
public interface IConstrucaoProperties {
    public int getLinha();
    public void setLinha(int linha);

    public int getColuna();
    public void setColuna(int coluna);
    
    public float getPreco();
    public void setPreco(float preco);
    
    public int getSatisfacao();
    public void setSatisfacao(int satisfacao);
    
    public float getRenda();
    public void setRenda(float renda);
    
    public boolean getConstruido();
    public void setConstruido(boolean estado);
    
    public Button getBotao();
    public void setBotao(Button botao);
    
    public Window getJanela();
    public void setJanela(Window janela);
    
    public abstract String getTipo();
    public abstract int getTempoConstrucao();
}
~~~

Método | Objetivo
-------| --------
`getLinha` | método que retorna a posição da linha da construcao.
`setLinha` | método que recebe como parâmetro um int e o defini no atributo linha da construcao.
`getColuna` | método que retorna a posição da coluna da construcao.
`setColuna` | método que recebe como parâmetro um int e o defini no atributo coluna da construcao.
`getPreco` | método que retorna o preco da construcao.
`setPreco` | método que recebe como parâmetro um float e o defini no atributo preco da construcao.
`getSatisfacao` | m
`setSatisfacao` | método.
`getRenda` | método.
`setRenda` | método.
`getConstruido` | método.
`setConstruido` | método.
`getBotao` | método.
`setBotao` | método.
`getJanela` | método.
`setJanela` | método.
`getTipo` | método.
`getTempoConstrucao` | método.


`criarDinheiroVisual` | método que cria um Group que contém o ícone e o texto referentes ao dinheiro e o retorna.


`getDinheiro` | método que retorna o dinheiro da cidade.
`getLayout` | método que retorna o layout da cidade.
`setLayout` | método que recebe como parâmetro uma matriz de IConstrucao e a defini no atributo layout da cidade.



#### Interface `IConstrucaoVisual`
Interface responsável pela criação visual da cidade e do dinheiro.

~~~java
package com.projeto.game.model.cidade;
…
public interface ICidadeVisual {
	public Table criarCidadeVisual();
	public Group criarDinheiroVisual();
}
~~~

Método | Objetivo
-------| --------
`criarCidadeVisual` | método que cria uma Table, configura suas dimensões e a retorna.
`criarDinheiroVisual` | método que cria um Group que contém o ícone e o texto referentes ao dinheiro e o retorna.













# Destaques de códgigo
Trechos relevantes do código

~~~java
// Recorte do seu código
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
}
~~~


# Destaques de Orientação a Objetos
Conceitos de OO utilizados no códgigo (sobrecarga de métodos, polimorfismo ...)

## Diagrama de Classes usada no destaque

## Código do Destaque

~~~java
// Recorte do código do destaque OO
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
}
~~~

# Destaques de Pattern
Foi adotado pela equipe, essencialmente, os seguintes Desing Patterns:
* Singleton
* Factory
* Strategy

## Desing Pattern 1: Singleton
O Pattern Singleton foi utilizado no projeto para gerar mais coesão ao código e evitar que determinados objetos sejam instanciados mais de uma vez. O padrão foi utilizado inúmeras vezes no código estando presente em quase todos os componentes. Não possui esse Pattern apenas componentes e classes que precisam ser instanciadas mais de uma vez (Componente `construcao` e Componente `eventos`)... 

### Diagrama do Pattern 1

### Exemplo de Código do Pattern 1
Esse exemplo representa o uso do Singleton no projeto, no caso do exemplo, para o instanciação da Populacao, seguindo o mesmo padrão para o restante do código.

1. O trecho de código foi retirado do Componente `populacao` e representa como foi estruturado o Pattern:
~~~java
package com.projeto.game.model.populacao;
…
public class Populacao implements IPopulacao{
   …
   private static IPopulacao instancia;
    …
   public static IPopulacao getInstancia() {
    	if ( instancia == null ) {
    		instancia = new Populacao();
    	}
    	return instancia;
    }
}
~~~


## Desing Pattern 2: Factory
O Pattern Factory foi utilizado no projeto para substituir chamadas diretas de instanciação promovendo uma organização do código no que diz respeito a criação dos objetos. As "fábricas"
foram utilizadas, fundamentalmente, em três momentos do código: Na construção de construções e na construção de elementos de GUI (graphical user interface).

### Diagramas do Pattern 2 
#### 

### Códigos do Pattern 2
Recortes de código da implementação das Factorys que demonstram como elas foram estruturadas.

1. Trecho de código retirado do Componente `construtor` e representa como foi feita a "fábrica" de construções: 
~~~java
package com.projeto.game.controller.construtor.construcoes;
…
public class FactoryConstrucao implements IFactoryConstrucao {
	final static private IBuildConstrucao CONSTRUTOR_CONSTRUCAO = ConstrutorConstrucao.getInstancia();
	…
	public IConstrucao criarConstrucao(String tipo, int linha, int coluna) {
		IConstrucao construcao;
		
		switch (tipo) {
			case "Moradia":
				construcao = CONSTRUTOR_CONSTRUCAO.buildMoradia(linha,coluna);
				…
				break;
			…
			default:
				construcao = CONSTRUTOR_CONSTRUCAO.buildVazio(linha,coluna);
				…
				break;
		}
		…
		return construcao;
	}
	…
}
~~~

2. Trecho de código retirado do Componente `construtor` e representa como foi feita a "fábrica" de elementos de GUI: 
~~~java
package com.projeto.game.controller.construtor.gui;
…
public class FactoryGui implements IFactoryGui {
    …
	public Button criarBotao(String tipo, String texto, float largura, float altura, int linha, int coluna) {
		Button botao;
		switch (tipo) {
		case "texto":
			botao = CONSTRUTOR_BOTAO.buildBotaoTexto(texto, largura, altura);
			break;
		…
		default:
			botao = null;
			break;
		}
		return botao;
	}
	
	public Window criarJanela(String tipo, String titulo, String texto, float largura, float altura, int linha, int coluna) {
		Window janela;
		
		String[] icones = {"Moradia", "Escola", "Hospital", "Industria", "Mercado", "Prefeitura"};
		
		switch (tipo) {
			case "texto":
				janela = CONSTRUTOR_JANELA.buildJanela(titulo, largura, altura);
				…
				break;
			case "construcao":
				janela = CONSTRUTOR_JANELA.buildJanela(titulo, largura, altura);
				…
				break;
			default:
				janela = null;
		}
		return janela;
	}
	…
}
~~~
Observação: o `FactoryGui` também implementa as funções de construção `criarLabel` e `criarDialog`.

## Desing Pattern 3: Strategy
O Pattern Strategy foi utilizado no projeto para fazer com que determinada classe (`EventoAleatorio`) possua algoritmos intercambiáveis, ou seja, fazer com que essa clase posso surtir diferentes efeitos (através dos diferentes algoritmos) sem que ela defina os algoritmos para isso. 

### Diagrama do Pattern 3

### Código do Pattern 3
Recortes de código da implementação da Strategy que demonstram sua definição e funionamento.

1. Trecho do código retirado do Componente `evento` e reprensenta como foi definida a Classe `EventoAleatorio`:
~~~java
package com.projeto.game.model.evento;
…
public class EventoAleatorio extends Evento {
	private IStrategyEventoAleatorio strategy;
	…
	public void executarEvento(ICidade cidade) {
		strategy.executarEventoAleatorio(cidade);
	}
}
~~~

2. Trecho do código retirado do Componente `evento` e representa como foi definida a Interface `IStrategyEventoAleatorio`:
~~~java
package com.projeto.game.model.evento;
…
public interface IStrategyEventoAleatorio {
	public void executarEventoAleatorio(ICidade cidade);
}
~~~

3. Trecho do código retirado do Componente `gerador` e representa como foi utilizado o Strategy:
~~~java
package com.projeto.game.model.gerador;
…
public class GeradorEventoAleatorio implements IGerarEventoAleatorio {
    …
    public EventoAleatorio gerarEventoAleatorio(int data){
        EventoAleatorio eventoAleatorio = new EventoAleatorio();
        IStrategyEventoAleatorio strategy;
        …
        switch (n) {
          case 1:
              strategy = new EventoAleatorioGreveGeral();
              break;
          …
          default:
              strategy = new EventoAleatorioMigracao();
        	  break;
        }
        …
        eventoAleatorio.setStrategy(strategy);
        …
    }
    …
~~~
Observação : As funções `EventoAleatorioGreveGeral` e `EventoAleatorioRepasseEstadual` (além de outras que não aprecem no trecho) definem os diferentes algoritmos a serem permutados pela Strategy e atribuídos no objeto gerado `eventoAleatorio`.    

# Plano de Exceções

## Diagrama de hierarquia de exceções

## Descrição das classes de exceções

Classe | Descrição
----- | -----
`<nome da classe>` | `<o que ela engloba>`
