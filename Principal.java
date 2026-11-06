//COLOCAR NOME E GRR AQUI 
//HAICO DE TOLEDO BOEHS GRR20253482

public class Principal {
    public static void main(String args[])
    {
        Entrada entrada = new Entrada();
        Gerenciador ger = new Gerenciador();
        boolean continuar = true;

         //rascunho do loop, o processo de leitura de entrada deve ocorrer assim
         //e a cada iteracao do loop, printamos o tabuleiro
        while (continuar) 
        {
            ger.desenharMapa();
            System.out.println("Turno do Player 1");
            while(!(ger.movimentarPlayer1(entrada.lerEntrada())))
            {
                System.out.println("Jogada inválida, tente novamente.");
            }
            // acao player 1
            ger.desenharMapa();
            System.out.println("Turno do Player 2");
            while(!(ger.movimentarPlayer2(entrada.lerEntrada())))
            {
                System.out.println("Jogada inválida, tente novamente.");
            }
            // acao player 2
        }
    }
}