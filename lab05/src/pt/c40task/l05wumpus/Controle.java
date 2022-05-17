package pt.c40task.l05wumpus;

import java.util.Scanner;

public class Controle {
    private Heroi player;

    public Controle(Heroi player){
        this.player = player;
    }

    public void moverParaCima(){
        player.desconectar();
        player.setLinha(player.getLinha()-1);
        player.conectar();
    }

    public void moverParaBaixo(){
        player.desconectar();
        player.setLinha(player.getLinha()+1);
        player.conectar();
    }
    public void moverParaDireita(){
        player.desconectar();
        player.setColuna(player.getColuna()+1);
        player.conectar();
    }
    public void moverParaEsquerda(){
        player.desconectar();
        player.setColuna(player.getColuna()-1);
        player.conectar();
    }

    public void equipaFlecha(){
        player.equipaFlecha();
    }

    public void capturaOuro(){
        player.capturaOuro();
    }



    public void iniciarLeitura(Caverna caverna, String movimentos){

        for ( int i = 0; i < movimentos.length(); i++ ){
            String movimento = movimentos.substring(0,1);
            movimentos = movimentos.substring(1,movimentos.length());
            
            switch(movimento){
                case "w":
                    moverParaCima();
                case "s":
                    moverParaBaixo();
                case "d":
                    moverParaDireita();
                case "a":
                    moverParaEsquerda();
                case "k":
                    equipaFlecha();
                case "c":
                    capturaOuro();
                case "q":
            }
        


            //mostrar caverna;
        
        }


    }

    public void iniciarInterativo(Caverna caverna)){
        Scanner teclado = new Scanner(System.in);
        String movimento = teclado.nextLine();

        while( movimento.equals("q") ){
            
            switch(movimento){
                case "w":
                    moverParaCima();
                case "s":
                    moverParaBaixo();
                case "d":
                    moverParaDireita();
                case "a":
                    moverParaEsquerda();
                case "k":
                    equipaFlecha();
                case "c":
                    capturaOuro();
            }

            
        }

    }

}
