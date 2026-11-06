//COLOCAR NOME E GRR AQUI 
//HAICO DE TOLEDO BOEHS GRR20253482

public class Principal {
    public static void main()
    {
        Gerenciador ger = new Gerenciador();
        boolean continuar = true;

         //rascunho do loop, o processo de leitura de entrada deve ocorrer assim
         //e a cada iteracao do loop, printamos o tabuleiro
        while (continuar) 
        {
            ger.desenharMapa();
            ger.movimentarEntidade(ger.p1, ger.p2, ger.lerEntrada());
        }
    }
}
