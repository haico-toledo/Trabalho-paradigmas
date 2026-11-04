import java.util.Scanner;

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
   private static final int MAX_X_MAPA = 4;
   private static final int MAX_Y_MAPA = 4;
   public Setor[][] mapa;
   public JogadorN p1;
   public JogadorS p2;


   public Gerenciador()
   {
     this.setP1(new JogadorN(ATK_INICIAL_P1, DEF_INICIAL_P1, X_INICIAL, Y_INICIAL));
     this.setP2(new JogadorS(ATK_INICIAL_P2, DEF_INICIAL_P2, X_INICIAL, Y_INICIAL));
     this.setMapa();
   }

   public Setor[][] getMapa()
   {
    return this.mapa;
   }
   public void setMapa()
   {
     if (this.mapa == null)
     {
       this.mapa = new Setor[PROPORCAO_MATRIZ][PROPORCAO_MATRIZ];
       this.estabelecerMapa();
     }
   }

   public JogadorN getP1()
   {
     return this.p1;
   }
   public void setP1(JogadorN p1)
   {
     if (p1 != null)
     {
        this.p1 = p1;
     }
   }

   public JogadorS getP2()
   {
    return this.p2;
   }
   public void setP2(JogadorS p2)
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
    if (this.getMapa() != null)
    {
      this.mapa[0][0] = new Setor(true, false, true, false, 1);
      this.mapa[0][1] = new Setor(true, false, false, false, 1);
      this.mapa[0][2] = new Setor(true, true, false, true, 2);
      this.mapa[0][3] = new Setor(true, false, true, false, 1);
      this.mapa[0][MAX_Y_MAPA] = new Setor(true, true, false, true, 2);

      this.mapa[1][0] = new Setor(false, true, true, true, 2);
      this.mapa[1][1] = new Setor(false, true, true, false, 0);
      this.mapa[1][2] = new Setor(true, false, false, true, 0);
      this.mapa[1][3] = new Setor(false, false, true, true, 0);
      this.mapa[1][MAX_Y_MAPA] = new Setor(true, false, true, true, 0);

      this.mapa[2][0] = new Setor(true, false, true, false, 0);
      this.mapa[2][1] = new Setor(true, false, false, false, 0);
      this.mapa[2][2] = new Setor(false, false, false, false, 0);
      this.mapa[2][3] = new Setor(false, true, false, false, 0);
      this.mapa[2][MAX_Y_MAPA] = new Setor(false, true, false, true, 0);

      this.mapa[3][0] = new Setor(false, false, true, true, 0);
      this.mapa[3][1] = new Setor(false, true, true, true, 0);
      this.mapa[3][2] = new Setor(false, true, true, false, 0);
      this.mapa[3][3] = new Setor(true, false, false, false, 0);
      this.mapa[3][MAX_Y_MAPA] = new Setor(true, true, false, true, 2);

      this.mapa[MAX_X_MAPA][0] = new Setor(false, true, true, false, 0);
      this.mapa[MAX_X_MAPA][1] = new Setor(true, true, false, false, 1);
      this.mapa[MAX_X_MAPA][2] = new Setor(true, true, false, true, 2);
      this.mapa[MAX_X_MAPA][3] = new Setor(false, true, true, false, 1);
      this.mapa[MAX_X_MAPA][MAX_Y_MAPA] = new Setor(true, true, false, true, 2);

      for (int x = 0; x < PROPORCAO_MATRIZ; x++)
      {
        for (int y = 0; y < PROPORCAO_MATRIZ; y++)
        {
          this.mapa[x][y].setVisitado(false);
        }
      }

      this.mapa[X_INICIAL][Y_INICIAL].setVisitado(true);
    }
   }
  
  ///Imprime os Jogadores e todos os setores do mapa. 
  /// Feito para debug, remover depois.
   public void imprimirJogo()
   {
    System.out.printf("P1: %n");
    (this.getP1()).imprimirAtributos();
    System.out.printf("P2: %n");
    (this.getP2()).imprimirAtributos();
    for (int x = 0; x < PROPORCAO_MATRIZ; x++)
      {
        for (int y = 0; y < PROPORCAO_MATRIZ; y++)
        {
          System.out.printf("SETOR[%d][%d]%n", x, y);
          (this.mapa[x][y]).imprimirSetor();
        }
      }
   }
  
  //retorna o primeiro caractere da entrada digitada
  public char lerEntrada()
  {
    Scanner teclado = new Scanner(System.in);
    char tecla = teclado.next().charAt(0);
    while (tecla == '\n') {
      tecla = teclado.next().charAt(0);
    }

    teclado.close();

    return tecla;
  }

  //passar a funcao lerEntrada no parametro tecla para movimentar o jogador com base na entrada do teclado
  public void movimentaEntidade(JogadorN p1, JogadorS p2, char tecla)
  {
    switch (tecla)
    {
      case 'w':
        if (p1.locy < MAX_Y_MAPA)
          p1.locy++;
        break;
      case 'a':
        if (p1.locx < MAX_X_MAPA)
          p1.locx--;
        break;
      case 'd':
        if (p1.locx < MAX_X_MAPA)
          p1.locx++;
        break;
      case 's':
        if (p1.locy < MAX_Y_MAPA)
          p1.locy--;
        break;
      default:
        break;
    }
    if (p2 != null) {
      switch (tecla)
      {
      case '8':
        if (p2.locy < MAX_Y_MAPA)
          p2.locy++;
        break;
      case '4':
        if (p2.locx < MAX_X_MAPA)
          p2.locx--;
        break;
      case '6':
        if (p2.locx < MAX_X_MAPA)
          p2.locx++;
        break;
      case '5':
        if (p2.locy < MAX_Y_MAPA)
          p2.locy--;
        break;
      default:
        break;
      }
    }
  }
}