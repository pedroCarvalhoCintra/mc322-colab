# Projeto `<Título do Jogo>`.

# Descrição
> O `<Título do Jogo>` é um jogo de construção de cidades em que o jogador deve assumir o papel de um prefeito e organizar sua cidade de modo a fazer com que ela prospere e que sua população fique satisfeita. Portanto, o jogo tem como próposito fazer com o que o jogador entenda como planejar de maneira eficiente e criativa o arranjo de construções da cidade fazendo com que ela progrida de acordo com as regras de jogo. 

# Equipe
* `Riccardo Carvalho Sofer - RA 247362`
* `Pedro Carvalho Cintra - RA 247315`

# Arquivo executável do jogo

# Slides do projeto

# Destaques de códgigo
> Trechos relevantes do código

~~~java
// Recorte do seu código
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
}
~~~


# Destaques de Orientação a Objetos
> Conceitos de OO utilizados no códgigo (sobrecarga de métodos, polimorfismo ...)

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
> Foi adotado pela equipe, essencialmente, os seguintes Desing Patterns:
* Singleton
* Factory
* Strategy

## Desing Pattern 1: Singleton
O Pattern Singleton foi utilizado no projeto para gerar mais coesão ao código e evitar que determinados objetos sejam instanciados mais de uma vez. O padrão foi utilizado inúmeras vezes no código estando presente em quase todos os componentes. Não possui esse Pattern apenas componentes e classes que precisam ser instanciadas mais de uma vez (Componente `construcao` e Componente `eventos`)... 

### Diagrama do Pattern 1

### Exemplo de Código do Pattern 1
Esse exemplo representa o uso do Singleton no projeto, no caso do exemplo, para o instanciação da Populacao, seguindo o mesmo padrão para o restante do código.

* O trecho de código foi tirado do Componente `populacao` e representa como foi estruturado o Pattern:
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
foram utilizadas, fundamentalmente, em três momentos do código: Na construção de construções, na construção de elementos da GUI (graphical user interface) e no gerador de eventos.

### Diagramas do Pattern 2 
#### 

### Códigos do Pattern 2


~~~java
// Recorte do código do pattern
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
}
~~~

## Desing Pattern 3: Strategy
O Pattern Strategy foi utilizado no projeto para fazer com que determinada classe (`EventoAleatorio`) possua algoritmos intercambiáveis, ou seja, fazer com que essa clase posso surtir diferentes efeitos (através dos diferentes algoritmos) sem que ela defina os algoritmos para isso. 

### Diagrama do Pattern 3

### Código do Pattern 3
Recortes de código da implementação da Strategy que demonstram sua definição e funionamento.

* Trecho do código tirado do Componente `evento` e reprensenta como foi definida a Classe `EventoAleatorio`:
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

* Trecho do código tirado do Componente `evento` e representa como foi definida a Interface `IStrategyEventoAleatorio`:
~~~java
package com.projeto.game.model.evento;
…
public interface IStrategyEventoAleatorio {
	public void executarEventoAleatorio(ICidade cidade);
}
~~~

* Trecho do código tirado do Componente `gerador` e representa como foi utilizado o Strategy:
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
          case 2:
              strategy = new EventoAleatorioMigracao();
              break;
          case 3:
              strategy = new EventoAleatorioRepasseEstadual();
              break; 
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
Observação : As funções `EventoAleatorioGreveGeral`, `EventoAleatorioMigracao` e `EventoAleatorioRepasseEstadual` definem os diferentes algoritmos a serem permutados pela Strategy.  

# Diagramas

## Diagrama geral de Arquitetura do Jogo


## Diagram geral de Componentes  


## Componente `<nome do componente>`
> Resumo do componente



**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | `<nome dos membros que criaram o componente>`
Interfaces | `<listagem das interfaces do componente>`

### interfaces 
> interfaces associadas a esse componente

> interface agregador do componente em java
~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~


## Detalhamento das interfaces

### Interface `<nome da interface>`

resumo da interface

~~~java
//interface me java.
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

# Plano de Exceções

## Diagram de hierarquia de exceções

## Descrição das classes de exceções

Classe | Descrição
----- | -----
`<nome da classe>` | `<o que ela engloba>`