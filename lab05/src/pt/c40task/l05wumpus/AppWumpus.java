package pt.c40task.l05wumpus;

public class AppWumpus {
   
   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
      
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
	  Montador montador = new Montador(tk);
      Caverna caverna = montador.construirCaverna();

      if (caverna != null){
         Controle controle = new Controle(tk, caverna);
         if (arquivoMovimentos == null)
        	 controle.iniciarInterativo();
         else
            controle.iniciarLeitura();
      }
      tk.stop();
   }

}