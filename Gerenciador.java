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
  private Setor[][] mapa;
  private JogadorN p1;
  private JogadorS p2;


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

  public void desenharMapa()
  {
    this.desenharCabecalho();
    String[] painel = this.gerarPainel();
    for (int y = 0; y <= MAX_Y_MAPA; y++)
      System.out.print(this.gerarLinhaMapa(y, painel));
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
  
  //passar a funcao lerEntrada no parametro tecla para movimentar o jogador com base na entrada do teclado
  public boolean movimentarPlayer1(char tecla)
  {
    Setor setor = this.mapa[this.p1.locy][this.p1.locx];
    switch (tecla)
    {
      case 'w':
        if (this.p1.locy > 0 && !setor.getParedecima())
          this.p1.locy--;
        else
          return false;
        break;
      case 'a':
        if (this.p1.locx > 0 && !setor.getParedeesq())
          this.p1.locx--;
        else
          return false;
        break;
      case 'd':
        if (this.p1.locx < MAX_X_MAPA && !setor.getParededir())
          this.p1.locx++;
        else
          return false;
        break;
      case 's':
        if (this.p1.locy < MAX_Y_MAPA && !setor.getParedebaixo())
          this.p1.locy++;
        else
          return false;
        break;
      default:
        return false;
    }
    this.mapa[this.p1.locy][this.p1.locx].setVisitado(true);
    return true;
  }

  public boolean movimentarPlayer2(char tecla)
  {
    if (this.p2 != null) {
      Setor setor = this.mapa[this.p2.locy][this.p2.locx];
      switch (tecla)
      {
      case '8':
        if (this.p2.locy > 0 && !setor.getParedecima())
          this.p2.locy--;
        else
          return false;
        break;
      case '4':
        if (this.p2.locx > 0  && !setor.getParedeesq())
          this.p2.locx--;
        else
          return false;
        break;
      case '6':
        if (this.p2.locx < MAX_X_MAPA  && !setor.getParededir())
          this.p2.locx++;
        else
          return false;
        break;
      case '5':
        if (this.p2.locy < MAX_Y_MAPA && !setor.getParedebaixo())
          this.p2.locy++;
        else
          return false;
        break;
      default:
        return false;
      }
      this.mapa[p2.locy][p2.locx].setVisitado(true);
      return true;
    }
    return false;
  }

  private void desenharCabecalho() 
  {
    System.out.println("------------------------------");
    System.out.println("|    Antivírus por um dia    |");
    System.out.println("------------------------------");
    System.out.println("      1   2   3   4   5");
    System.out.println("    |---|---|---|---|---|");
  }

  private String getConteudoSetor(int x, int y) 
  {
    if(x == X_INICIAL && y == Y_INICIAL) 
      return " C ";
    if(this.p1.locx == x && this.p1.locy == y) 
      return "P1 ";
    if(this.p2.locx == x && this.p2.locy == y) 
      return "P2 ";

    return "   ";
  }

  private static final int LARGURA_PAINEL = 15;

  private String[] montarPainel(int x, int y, String inimigos, String jogadores, String atributos)
  {
    Setor s = this.mapa[y][x];
    char cima  = s.getParedecima()  ? '-' : '*';   // ajuste ao nome real do getter
    char baixo = s.getParedebaixo() ? '-' : '*';
    char esq   = s.getParedeesq()   ? '|' : '*';
    char dir   = s.getParededir()   ? '|' : '*';

    String[] p = new String[2 * (MAX_Y_MAPA + 1)];
    p[0] = "Setor [%d,%d]".formatted(x + 1, y + 1);
    p[1] = "";
    p[2] = "|------" + cima + "------|";
    p[3] = "| %-11s |".formatted(inimigos);
    p[4] = "|" + "             " + "|";
    p[5] = esq + "             " + dir;
    // com - antes do 11 o texto fica alinhado a esquerda e completa direita com espaços
    p[6] = "| %-11s |".formatted(jogadores); 
    p[7] = "| %-11s |".formatted(atributos);
    p[8] = "|------" + baixo + "------|";
    p[9] = "";
    return p;
  }

  private String getInimigosPorSetor(Setor setor)
  {
    Entidade[] inimigos = setor.getInimigos();

    if (inimigos == null) return "";

    StringBuilder saida = new StringBuilder();
    for (Entidade inimigo : inimigos)
    {
      if (saida.length() > 0)
        saida.append(' ');
      saida.append(inimigo.resumoAtributos());
    }
    
    return saida.toString();
  }

  private String[] gerarPainel()
  {
    boolean mesmoSetor = this.p1.locx == this.p2.locx && this.p1.locy == this.p2.locy;

    if (mesmoSetor)
      return montarPainel(this.p1.locx, this.p1.locy, getInimigosPorSetor(this.mapa[this.p1.locy][this.p1.locx]), 
        "P1    P2", this.p1.resumoAtributos() + "   " + this.p2.resumoAtributos());

    String[] a = montarPainel(this.p1.locx, this.p1.locy, getInimigosPorSetor(this.mapa[this.p1.locy][this.p1.locx]), "P1", this.p1.resumoAtributos());
    String[] b = montarPainel(this.p2.locx, this.p2.locy, getInimigosPorSetor(this.mapa[this.p2.locy][this.p2.locx]), "P2", this.p2.resumoAtributos());

    String[] r = new String[a.length];
    for (int i = 0; i < r.length; i++)
      r[i] = String.format("%-" + LARGURA_PAINEL + "s   %s", a[i], b[i]);
    return r;
  }

  private StringBuilder gerarLinhaMapa(int y, String[] painel)
  {
    StringBuilder meio = new StringBuilder((y + 1) + "   ");
    StringBuilder base = new StringBuilder("    |");

    Setor primeiro = this.mapa[y][0];
    char charEsquerda = (primeiro.getVisitado() && !primeiro.getParedeesq()) ? '*' : '|';
    meio.append(charEsquerda);

    for (int x = 0; x <= MAX_X_MAPA; x++)
    {
      Setor s = this.mapa[y][x];
      Setor dir = x < MAX_X_MAPA ? this.mapa[y][x + 1] : null;
      Setor baixo = y < MAX_Y_MAPA ? this.mapa[y + 1][x] : null;

      boolean visivelDir = s.getVisitado() || (dir != null && dir.getVisitado());
      boolean visivelBaixo = s.getVisitado() || (baixo != null && baixo.getVisitado());

      char charDireita = (visivelDir && !s.getParededir()) ? '*' : '|';
      char charBase = (visivelBaixo && !s.getParedebaixo()) ? '*' : '-';

      meio.append(getConteudoSetor(x, y)).append(charDireita);
      base.append('-').append(charBase).append("-|");
    }

    meio.append("   ").append(painel[2 * y]);
    base.append("   ").append(painel[2 * y + 1]);
    return meio.append('\n').append(base).append('\n');
  }
}