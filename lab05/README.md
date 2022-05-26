# Lab05 - Wumpus.

## Arquivos Java - Wumpus
[Arquivos Java](src/pt/c40task/l05wumpus)

## Destaques do Projeto
Corte da classe **"Sala"**:

![image](https://user-images.githubusercontent.com/102068958/170516427-91cf7580-998c-4f45-8a51-923971139daa.png)

Corte da classe abstrata **"Componente"**:

![image](https://user-images.githubusercontent.com/102068958/170516443-673425fb-c3cc-43e9-98fe-e19017cdb457.png)


O recorte mostrado demonstra alguns conceitos importantes: o **polimorfismo**, a **sobrecarga** de métodos e a **herança**. Cada componente é sempre **instanciado** como seu tipo (Herói, Wumpus, Ouro, etc), mas seu tipo **declarado**, com raras exceções, é **Componente**. Isso permite que eles sejam todos adicionados no vetor de cada Sala, e permite que, caso outro componente seja adicionado, ele poderá se conectar com as salas de maneira natural. O método conectar mostrado é interessante também, pois para as classes Wumpus e Buraco, ele é sobrecarregado, e adiciona os componentes Brisa e Fedor. Por fim, os métodos abstratos são sempre implementados pelas subclasses, cada um com um retorno específico de cada uma (“P” para Heroi, “W” para Wumpus, etc) e permitindo, novamente, fácil expansão.
