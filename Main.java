public class Main
{
  public static void main(String args[])
  {
    ///Assim que Batalha foi instanciado, tanto os jogadores 
    /// quanto cada setor do mapa já possui os dados esperados
    /// Então, o próximo passo é a lógica do jogo, seja ela feita no main ou dentro do Gerenciador.
    Gerenciador Batalha = new Gerenciador();
    Batalha.imprimirJogo();
  }
}