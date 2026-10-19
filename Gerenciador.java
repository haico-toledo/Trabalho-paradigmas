public class Gerenciador
{
   private static final int ATK_INICIAL_P1 = 2;
   private static final int DEF_INICIAL_P1 = 6;
   private static final int ATK_INICIAL_P2 = 1;
   private static final int DEF_INICIAL_P2 = 7;
   private static final int ATK_DEF_MAXIMO_INIMIGOS = 3;
   private static final int MAX_INIMIGOS_NO_SETOR = 3;
   private static final int PROPORCAO_MATRIZ = 5;
   private static final int X_INICIAL = 2;
   private static final int Y_INICIAL = 2;
   public Setor[][] mapa;
   public JogadorN p1;
   public JogadorS p2;


   public Gerenciador()
   {
     this.setp1(new JogadorN(ATK_INICIAL_P1, DEF_INICIAL_P1, X_INICIAL, Y_INICIAL));
     this.setp2(new JogadorS(ATK_INICIAL_P2, DEF_INICIAL_P2, X_INICIAL, Y_INICIAL));
     this.setmapa();
   }

   public Setor[][] getmapa()
   {
    return this.mapa;
   }
   public void setmapa()
   {
     if (this.mapa == null)
     {
       this.mapa = new Setor[PROPORCAO_MATRIZ][PROPORCAO_MATRIZ];
       this.estabelecerMapa();
     }
   }

   public JogadorN getp1()
   {
     return this.p1;
   }
   public void setp1(JogadorN p1)
   {
     if (p1 != null)
     {
        this.p1 = p1;
     }
   }

   public JogadorS getp2()
   {
    return this.p2;
   }
   public void setp2(JogadorS p2)
   {
     if (p2 != null)
     {
       this.p2 = p2;
     }
   }
   
   ///Caso mapa já tenha sido alocado, estabelece o mapa do jogo.
   /// Instancia cada posição da matriz 5x5 uma por uma.
   public void estabelecerMapa()
   {
    if (this.getmapa() != null)
    {
      this.mapa[0][0] = new Setor(true, false, true, false, 1);
      this.mapa[0][1] = new Setor(true, false, false, false, 1);
      this.mapa[0][2] = new Setor(true, true, false, true, 2);
      this.mapa[0][3] = new Setor(true, false, true, false, 1);
      this.mapa[0][4] = new Setor(true, true, false, true, 2);

      this.mapa[1][0] = new Setor(false, true, true, true, 2);
      this.mapa[1][1] = new Setor(false, true, true, false, 0);
      this.mapa[1][2] = new Setor(true, false, false, true, 0);
      this.mapa[1][3] = new Setor(false, false, true, true, 0);
      this.mapa[1][4] = new Setor(true, false, true, true, 0);

      this.mapa[2][0] = new Setor(true, false, true, false, 0);
      this.mapa[2][1] = new Setor(true, false, false, false, 0);
      this.mapa[2][2] = new Setor(false, false, false, false, 0);
      this.mapa[2][3] = new Setor(false, true, false, false, 0);
      this.mapa[2][4] = new Setor(false, true, false, true, 0);

      this.mapa[3][0] = new Setor(false, false, true, true, 0);
      this.mapa[3][1] = new Setor(false, true, true, true, 0);
      this.mapa[3][2] = new Setor(false, true, true, false, 0);
      this.mapa[3][3] = new Setor(true, false, false, false, 0);
      this.mapa[3][4] = new Setor(true, true, false, true, 2);

      this.mapa[4][0] = new Setor(false, true, true, false, 0);
      this.mapa[4][1] = new Setor(true, true, false, false, 1);
      this.mapa[4][2] = new Setor(true, true, false, true, 2);
      this.mapa[4][3] = new Setor(false, true, true, false, 1);
      this.mapa[4][4] = new Setor(true, true, false, true, 2);

      for (int x = 0; x < PROPORCAO_MATRIZ; x++)
      {
        for (int y = 0; y < PROPORCAO_MATRIZ; y++)
        {
          this.mapa[x][y].setvisitado(false);
        }
      }

      this.mapa[X_INICIAL][Y_INICIAL].setvisitado(true);
    }
   }

  ///Imprime os Jogadores e todos os setores do mapa. 
  /// Feito para debug, remover depois.
   public void imprimirJogo()
   {
    System.out.printf("P1: %n");
    (this.getp1()).imprimirAtributos();
    System.out.printf("P2: %n");
    (this.getp2()).imprimirAtributos();
    for (int x = 0; x < PROPORCAO_MATRIZ; x++)
      {
        for (int y = 0; y < PROPORCAO_MATRIZ; y++)
        {
          System.out.printf("SETOR[%d][%d]%n", x, y);
          (this.mapa[x][y]).imprimirSetor();
        }
      }
   }
}