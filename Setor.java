public class Setor
{
  ///Se houver parece naquela determinada direção, deve ser true, caso contrário, false. 
  private boolean paredecima; 
  private boolean paredebaixo;
  private boolean paredeesq;
  private boolean parededir;
  ///True se um jogador já adentrou o setor, false caso contrário.
  private boolean visitado;
  ///0 normal; 1 oculto; 2 privado.
  private int tiposetor; 
  ///Vetor de vírus que armazena os inimigos gerados para a batalha.
  private Entidade[] inimigos;

  public Setor(boolean paredecima, boolean paredebaixo, boolean paredeesq, boolean parededir, int tiposetor)
  {
    this.setParedecima(paredecima);
    this.setParedebaixo(paredebaixo);
    this.setParedeesq(paredeesq);
    this.setParededir(parededir); 
    this.setTiposetor(tiposetor);
  }

  public boolean getParedecima()
  {
    return this.paredecima;
  }
  public void setParedecima(boolean paredecima)
  {
    this.paredecima = paredecima;
  }

  public boolean getParedebaixo()
  {
    return this.paredebaixo;
  }
  public void setParedebaixo(boolean paredebaixo)
  {
    this.paredebaixo = paredebaixo;
  }

  public boolean getParedeesq()
  {
    return this.paredeesq;
  }
  public void setParedeesq(boolean paredeesq)
  {
    this.paredeesq = paredeesq;
  }

  public boolean getParededir()
  {
    return this.parededir;
  }
  public void setParededir(boolean parededir)
  {
    this.parededir = parededir;
  }

  public boolean getVisitado()
  {
    return this.visitado;
  }
  public void setVisitado(boolean visitado)
  {
    if (this.visitado != true)
    {
      this.visitado = visitado;
    }
  }

  public int getTiposetor()
  {
    return this.tiposetor;
  }
  public void setTiposetor(int tiposetor)
  {
    if (tiposetor >= 0 && tiposetor < 3)
    {
      this.tiposetor = tiposetor;
    }
  }

  public Entidade[] getInimigos()
  {
    return this.inimigos;
  }
  public void setInimigos(Entidade[] inimigos)
  {
    if (inimigos != null)
    {
      this.inimigos = inimigos;
    }
  }

  public Entidade getInimigo(int posicao)
  {
    return this.inimigos[posicao];
  }

  ///Dado a posição do Inimigo no vetor de inimigos, o instancia.
  public void instanciarInimigo(int posicao, int atk, int def, int locx, int locy)
  {
    if (this.getInimigos() != null)
    {
      this.inimigos[posicao] = new Entidade(atk, def, locx, locy);
    }
  }

  ///Imprime os atributos do objeto. Feito para debug.
  public void imprimirSetor()
  {
    System.out.printf("PAREDE EM CIMA: %b %nPAREDE EMBAIXO: %b %nPAREDE NA ESQUERDA: %b %nPAREDE NA DIREITA: %b %nTIPO: %d %n %n", this.getParedecima(), this.getParedebaixo(), this.getParedeesq(), this.getParededir(), this.getTiposetor());
  }
}