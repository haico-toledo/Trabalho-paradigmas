import java.util.Random;
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
  private static final int LARGURA_PAINEL = 15;
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
  
  ///Dado um Jogador (seja JogadorN ou JogadorS, não é preciso fazer casting) e uma tecla, movimenta  o jogador em questão.
  /// Caso p seja JogadorN utiliza WASD, caso seja um JogadorS, utiliza 8462. 
  /// Retorna true se o movimento foi realizado e false c.c.
  private boolean movimentarPlayer(JogadorN p, char tecla)
  {
    if (p != null)
    {
      char cima;
      char esquerda;
      char direita;
      char baixo;
      if (p instanceof JogadorS)
      {
        cima = '8';
        esquerda = '4';
        direita = '6';
        baixo = '2';
      }
      else
      {
        cima = 'w';
        esquerda = 'a';
        direita = 'd';
        baixo = 's';
      }

      int locx = p.getLocx();
      int locy = p.getLocy();
      Setor setor = this.getMapa()[locy][locx];
      if (tecla == cima)
      {
          if (locy > 0 && !setor.isParedecima())
            p.setLocy(locy - 1);
          else
            return false;     
      }
      else if (tecla == esquerda)
      {
          if (locx > 0 && !setor.isParedeesq())
            p.setLocx(locx - 1);
          else
            return false;
      }
      else if (tecla == direita)
      {
          if (locx < MAX_X_MAPA && !setor.isParededir())
            p.setLocx(locx + 1);
          else
            return false;
      }
      else if (tecla == baixo)
      {
          if (locy < MAX_Y_MAPA && !setor.isParedebaixo())
            p.setLocy(locy + 1);
          else
            return false;
      }
      else
      {
        return false;
      }
      return true;
      }
    else
    {
      return false;
    }
  }

  ///Lê uma entrada do teclado e realiza a ação do jogador fornecido.
  /// Além do jogador e do teclado, deve receber um vetor de tamanho 1,
  /// que por sua vez é usado para retornar os pontos de ação
  /// após realizar a ação.
  private int acaoPlayer(JogadorN p, Entrada teclado, int[] PA)
  {
    if (p != null)
    {
      char atacar;
      char procurar;
      char recuperar;
      if (p instanceof JogadorS)
      {
        atacar = '4';
        procurar = '8';
        recuperar = '6';
      }
      else
      {
        atacar = 'a';
        procurar = 'w';
        recuperar = ' ';
      }
      int locx = p.getLocx();
      int locy = p.getLocy();
      Setor setor = this.getMapa()[locy][locx];
      char tecla;
      System.out.printf("Pontos de ação: %d%n", PA[0]);
      tecla = teclado.lerEntrada();
      int tipo_setor = setor.getTiposetor();
      if (tecla == atacar)
      {
        if (setor.getQtdinimigos() <= 0)
          System.out.printf("                                                                          Não há inimigos neste setor. Tente novamente.%n");        
        else
        {
          System.out.printf("ATAQUE: Escolha qual inimigo atacar:%n");
          Entidade[] vetor = setor.getInimigos();
          for (int x = 0; x < setor.getQtdinimigos(); x++)
          {
            System.out.printf("Inimigo %d: (%d/%d) |", x, vetor[x].getAtk(), vetor[x].getDef());
          }
          System.out.printf("%n");
          int pos_alvo = teclado.LerInt();
          while(!(pos_alvo >= 0 && pos_alvo < setor.getQtdinimigos()))
          {
            System.out.printf("                                                                          O inimigo digitado não existe. Tente novamente.%n");
            pos_alvo = teclado.LerInt();
          }

          Entidade alvo = setor.getInimigo(pos_alvo);
          int acerto = 1;
          if (tipo_setor == 1)
          {
            Random aleatorio = new Random();
            acerto = aleatorio.nextInt(2);
          }
          (PA[0])--;
          if (acerto == 1)
          {
            p.atacar(alvo);
            if (alvo.getDef() <= 0)
            {
              for (int x = pos_alvo; x < setor.getQtdinimigos() - 1; x++)
              {
                vetor[x] = vetor [x + 1];
              }
              setor.setQtdinimigos(setor.getQtdinimigos() - 1);
              this.mensagemAcao(1);
              return 1;
            }
          }
          else
          {
            System.out.printf("                                                                          Você errou o ataque!%n");
            this.mensagemAcao(2);
            return 2;
          }
        }
      }
      else if (tecla == procurar)
      {
        PA[0]--;
        if (tipo_setor == 2)
        {
          this.mensagemAcao(3);
          return 3;
        }
        else
        {
          int resultado_procura = p.procurar(setor);
          if (resultado_procura == -1 || resultado_procura == -2)
          {
            if (resultado_procura == -1)
            {
              this.mensagemAcao(4);
              return 4;
            }
            else
            {
              this.mensagemAcao(5);
              return 5;
            }
          }
          else if (resultado_procura >= 0 && setor.getQtdinimigos() >= 0)
          {
            this.mensagemAcao(6);
            return 6;
          }
          else
          {
            this.mensagemAcao(7);
            return 7;
          }
        }
      }
      else if (tecla == recuperar && p instanceof JogadorS && PA[0] >= 2)
      {
        System.out.printf("RECUPERAR: Escolha qual jogador recuperar.%nDigite 1 para recuperar P1 ou 2 para recuperar P2.%n");  
        tecla = teclado.lerEntrada();
        while (!(tecla == '1' || tecla == '2'))
        {
          System.out.printf("Resposta inválida, tente novamente.%n");
          tecla = teclado.lerEntrada();
        }

        Entidade alvo;
        JogadorS ps = (JogadorS) p;
        if (tecla == '1')
        {
          alvo = this.getP1();
          int retornorecuperar = ps.recuperarDef(alvo);
          if (retornorecuperar == 0)
          {
            this.mensagemAcao(10);
            return 10;
          }
          this.mensagemAcao(8);
          PA[0] = PA[0] - 2;
          return 8;
        }
        else 
        {
          alvo = ps;
          ps.recuperarDef(alvo);
          this.mensagemAcao(9);
          PA[0] = PA[0] - 2;
          return 9;
        }
      }
    }
    return 0;
  }

///Baseado no retorno de acaoPlayer(), imprime uma mensagem correspondente.
  private void mensagemAcao(int retorno_acaoplayer)
  {
    if (retorno_acaoplayer == 1)
    {
      System.out.printf("                                                                          Ataque efetuado!%n");
    }
    else if (retorno_acaoplayer == 2)
    {
      System.out.printf("                                                                          Errou o ataque!%n");
    }
    else if (retorno_acaoplayer == 3)
    {
      System.out.printf("                                                                          Este setor é privado. Não foi possível procurar.%n");
    }
    else if (retorno_acaoplayer == 4)
    {
      System.out.printf("                                                                          Você recuperou 1 de DEF!%n");
    }
    else if (retorno_acaoplayer == 5)
    {
      System.out.printf("                                                                          Você recuperou 2 de DEF!%n");
    }
    else if (retorno_acaoplayer == 6)
    {
      System.out.printf("                                                                          Causou 1 de dano em todos os inimigos!%n");
    }
    else if (retorno_acaoplayer == 7)
    {
      System.out.printf("                                                                          Você procurou, mas nada aconteceu...%n");
    }
    else if (retorno_acaoplayer == 8)
    {
      System.out.printf("                                                                          O player 1 teve sua DEF recuperada%n");
    }
    else if (retorno_acaoplayer == 9)
    {
      System.out.printf("                                                                          O player 2 teve sua DEF recuperada%n");
    }
    else if(retorno_acaoplayer == 10)
    {
      System.out.printf("                                                                          Esse jogador não está no mesmo setor que você.%n");
    }
  }

  ///Realiza o turno dos inimigos que estiverem dentro do mesmo setor que qualquer um dos jogadores.
  private void turnoInimigos(Setor setor, int x_setor, int y_setor)
  {
    int quantidade_inimigos = setor.getQtdinimigos();
    if (quantidade_inimigos > 0)
    {
      int locxp1 = this.getP1().getLocx();
      int locyp1 = this.getP1().getLocy();
      int locxp2 = this.getP2().getLocx();
      int locyp2 = this.getP2().getLocy();
      Entidade inimigo;
      boolean p1_presente = (locxp1 == x_setor && locyp1 == y_setor);
      boolean p2_presente = (locxp2 == x_setor && locyp2 == y_setor) && (this.getP2().getDef() > 0);
      for (int x = 0; x < quantidade_inimigos; x++)
      {
        inimigo = setor.getInimigo(x);
        if (p1_presente)
          inimigo.atacar(this.getP1());
        if (p2_presente)
          inimigo.atacar(this.getP2());
      }
    }
  }

  ///Realiza um turno.
  private int Turno(int locx_ninho, int locy_ninho, Entrada teclado)
  {
    JogadorN p1 = this.getP1();
    JogadorS p2 = this.getP2();
    Setor[][] mapa = this.getMapa();
    int x = 0;
    int[] PA = new int[1];
    if (p1.getDef() <= 0)
    {
      return -1;
    }
    else
    {  
      Setor setor_anteriorP1 = mapa[p1.getLocy()][p1.getLocx()];
      if (setor_anteriorP1.getQtdinimigos() <= 0) ///Caso não haja inimigos, movimento permitido.
      {
        System.out.printf("Movimento do Player 1:%n-CIMA: w%n-ESQUERDA: a%n-DIREITA: d%n-BAIXO: s%n"); ///Movimento Player 1
        while (!(this.movimentarPlayer(p1, teclado.lerEntrada())))
        {
          System.out.printf("                                                                          Movimento inválido, tente novamente.%n");
        }
        if (locx_ninho == p1.getLocx() && locy_ninho == p1.getLocy())
        {
          System.out.printf("                                                                          VITÓRIA DO PLAYER 1: O player 1 adentrou a fonte de infecção.%n");
          return -2;
        } 
        this.desenharMapa();
        System.out.printf("                                                                          PLAYER 1 se moveu!%n");
      }


      Setor setor_anteriorP2 = mapa[p2.getLocy()][p2.getLocx()];
      if (setor_anteriorP2.getQtdinimigos() <= 0 && p2.getDef() > 0) ///Caso não haja inimigos, movimento permitido.
      {
        System.out.printf("Movimento do Player 2:%n-CIMA: 8%n-ESQUERDA: 4%n-DIREITA: 6%n-BAIXO: 2%n"); ///Movimento Player 2
        while(!(this.movimentarPlayer(p2, teclado.lerEntrada())))
        {
          System.out.printf("                                                                          Movimento inválido, tente novamente.%n");
        }
        
        if (locx_ninho == p2.getLocx() && locy_ninho == p2.getLocy())
        {
          System.out.printf("                                                                          VITÓRIA DO PLAYER 2: O player 2 adentrou a fonte de infecção.%n");
          return -3;
        } 
        this.desenharMapa();
        System.out.printf("                                                                          PLAYER 2 se moveu!%n");
      }

      
      int locxp1 = p1.getLocx();
      int locyp1 = p1.getLocy();
      int locxp2 = p2.getLocx();
      int locyp2 = p2.getLocy();
      Setor setor_atualP1 = mapa[locyp1][locxp1];
      Setor setor_atualP2 = mapa[locyp2][locxp2];
      boolean juntos = (locxp1 == locxp2 && locyp1 == locyp2);
      Random aleatorio = new Random();
      int qtd_inimigos;
      boolean novos_inimigos = false;
      if (!(setor_atualP1.isVisitado()))
      {
        setor_atualP1.setInimigos(new Entidade[MAX_INIMIGOS_NO_SETOR]);
        qtd_inimigos = aleatorio.nextInt(MAX_INIMIGOS_NO_SETOR) + 1; 
        setor_atualP1.setQtdinimigos(qtd_inimigos);
        for (x = 0; x < qtd_inimigos; x++)
        {
          setor_atualP1.instanciarInimigo(x, ATK_DEF_MAXIMO_INIMIGOS, locyp1, locxp1);
        }     
        novos_inimigos = true;
      }

      if (!(setor_atualP2.isVisitado()) && !(juntos))
      {
        setor_atualP2.setInimigos(new Entidade[MAX_INIMIGOS_NO_SETOR]);
        qtd_inimigos = aleatorio.nextInt(MAX_INIMIGOS_NO_SETOR) + 1; 
        setor_atualP2.setQtdinimigos(qtd_inimigos);
        for (x = 0; x < qtd_inimigos; x++)
        {
          setor_atualP2.instanciarInimigo(x, ATK_DEF_MAXIMO_INIMIGOS, locyp2, locxp2);
        }  
        novos_inimigos = true;
      }

      if (novos_inimigos)
      {
        this.desenharMapa();
        System.out.printf("                                                                          Inimigos encontrados!%n");
      }

      PA[0] = 2;
      if (!novos_inimigos)
        this.desenharMapa();
      do
      {
        System.out.printf("AÇÕES DO PLAYER 1:%n-ATACAR: a%n-PROCURAR: w%n");
        this.acaoPlayer(p1, teclado, PA);
        this.desenharMapa();
      }
      while (PA[0] > 0);

      PA[0] = 2;
      if (p2.getDef() > 0)
      {
        if (!novos_inimigos)
          this.desenharMapa();
        do
        {
          System.out.printf("AÇÕES DO PLAYER 2:%n-ATACAR: 4%n-PROCURAR: 8%n-RECUPERAR: 6%n");
          this.acaoPlayer(p2, teclado, PA);
          this.desenharMapa();
        }
        while (PA[0] > 0);
      }

      if (setor_atualP1.getQtdinimigos() > 0 || setor_atualP2.getQtdinimigos() > 0)
      {
        System.out.printf("                                                                          Os inimigos atacaram!%n");
        this.turnoInimigos(setor_atualP1, locxp1, locyp1);
        if (!(juntos))
        {
          this.turnoInimigos(setor_atualP2, locxp2, locyp2);
        }
      }
     
      mapa[locyp1][locxp1].setVisitado(true);
      mapa[locyp2][locxp2].setVisitado(true);
      return 0;
    }
  }

  ///Executa o jogo.
  public void Jogo(Entrada teclado)
  {
    if (this.getP1() == null || this.getP2() == null || this.getMapa() == null)
    {
      return;
    }
    int turnos = 0;
    Random aleatorio = new Random();
    int locx_ninho = aleatorio.nextInt(PROPORCAO_MATRIZ);
    int locy_ninho = aleatorio.nextInt(PROPORCAO_MATRIZ);
    int resultado_turno;
    
    do
    {
    this.desenharMapa();
    System.out.printf("[TURNO %d]%n", turnos);
    resultado_turno = Turno(locx_ninho, locy_ninho, teclado);
    turnos++;
    }
    while(resultado_turno >= 0 && turnos < 25);
  }

  ///Desenha o tabuleiro e o painel.
  public void desenharMapa()
  {
    this.desenharCabecalho();
    String[] painel = this.gerarPainel();
    for (int y = 0; y <= MAX_Y_MAPA; y++)
      System.out.print(this.gerarLinhaMapa(y, painel));
    System.out.printf("-------------------------------------------------------------------------------------------------------------------------------%n");
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
    String retorno = "   ";
    if(x == X_INICIAL && y == Y_INICIAL) 
      retorno = " C ";
    if(this.p1.locx == x && this.p1.locy == y) 
      retorno = "P1 ";
    if(this.p2.locx == x && this.p2.locy == y) 
      retorno ="P2 ";
    if ((this.p2.locx == x && this.p2.locy == y) && (this.p1.locx == x && this.p1.locy == y))
      retorno = " P ";
    return retorno;
  }

  private String[] montarPainel(int x, int y, String inimigos, String jogadores, String atributos)
  {
    Setor s = this.mapa[y][x];
    char cima  = s.isParedecima()  ? '-' : '*';   // ajuste ao nome real do getter
    char baixo = s.isParedebaixo() ? '-' : '*';
    char esq   = s.isParedeesq()   ? '|' : '*';
    char dir   = s.isParededir()   ? '|' : '*';

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
    int quantidade_inimigos = setor.getQtdinimigos();
    if (inimigos == null) return "";

    StringBuilder saida = new StringBuilder();
    for (int x = 0; x < quantidade_inimigos; x++)
    {
        if (saida.length() > 0)
          saida.append(' ');
        saida.append(inimigos[x].resumoAtributos());
    }
    
    return saida.toString();
  }

  private String[] gerarPainel()
  {
    boolean mesmoSetor = this.p1.locx == this.p2.locx && this.p1.locy == this.p2.locy;

    if (mesmoSetor)
      return montarPainel(this.p1.locx, this.p1.locy, getInimigosPorSetor(this.mapa[this.p1.locy][this.p1.locx]), 
        "P1    P2", this.p1.resumoAtributos() + "   " + this.p2.resumoAtributos());

    String[] a = montarPainel(this.p1.locx, this.p1.locy, getInimigosPorSetor(this.mapa[this.p1.locy][this.p1.locx]), "P1", this.p1.resumoAtributos()); ////
    String[] b = montarPainel(this.p2.locx, this.p2.locy, getInimigosPorSetor(this.mapa[this.p2.locy][this.p2.locx]), "P2", this.p2.resumoAtributos());////

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
    char charEsquerda = (primeiro.isVisitado() && !primeiro.isParedeesq()) ? '*' : '|';
    meio.append(charEsquerda);

    for (int x = 0; x <= MAX_X_MAPA; x++)
    {
      Setor s = this.mapa[y][x];
      Setor dir = x < MAX_X_MAPA ? this.mapa[y][x + 1] : null;
      Setor baixo = y < MAX_Y_MAPA ? this.mapa[y + 1][x] : null;

      boolean visivelDir = s.isVisitado() || (dir != null && dir.isVisitado());
      boolean visivelBaixo = s.isVisitado() || (baixo != null && baixo.isVisitado());

      char charDireita = (visivelDir && !s.isParededir()) ? '*' : '|';
      char charBase = (visivelBaixo && !s.isParedebaixo()) ? '*' : '-';

      meio.append(getConteudoSetor(x, y)).append(charDireita); /////
      base.append('-').append(charBase).append("-|");
    }

    meio.append("   ").append(painel[2 * y]);
    base.append("   ").append(painel[2 * y + 1]);
    return meio.append('\n').append(base).append('\n');
  }
}