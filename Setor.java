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
    this.setparedecima(paredecima);
    this.setparedebaixo(paredebaixo);
    this.setparedeesq(paredeesq);
    this.setparededir(parededir); 
    this.settiposetor(tiposetor);
  }

  public boolean getparedecima()
  {
    return this.paredecima;
  }
  public void setparedecima(boolean paredecima)
  {
    this.paredecima = paredecima;
  }

  public boolean getparedebaixo()
  {
    return this.paredebaixo;
  }
  public void setparedebaixo(boolean paredebaixo)
  {
    this.paredebaixo = paredebaixo;
  }

  public boolean getparedeesq()
  {
    return this.paredeesq;
  }
  public void setparedeesq(boolean paredeesq)
  {
    this.paredeesq = paredeesq;
  }

  public boolean getparededir()
  {
    return this.parededir;
  }
  public void setparededir(boolean parededir)
  {
    this.parededir = parededir;
  }

  public boolean getvisitado()
  {
    return this.visitado;
  }
  public void setvisitado(boolean visitado)
  {
    if (this.visitado != true)
    {
      this.visitado = visitado;
    }
  }

  public int gettiposetor()
  {
    return this.tiposetor;
  }
  public void settiposetor(int tiposetor)
  {
    if (tiposetor >= 0 && tiposetor < 3)
    {
      this.tiposetor = tiposetor;
    }
  }

  public Entidade[] getinimigos()
  {
    return this.inimigos;
  }
  public void setinimigos(Entidade[] inimigos)
  {
    if (inimigos != null)
    {
      this.inimigos = inimigos;
    }
  }

  public Entidade getinimigo(int posicao)
  {
    return this.inimigos[posicao];
  }

  ///Dado a posição do Inimigo no vetor de inimigos, o instancia.
  public void instanciarInimigo(int posicao, int atk, int def, int locx, int locy)
  {
    if (this.getinimigos() != null)
    {
      this.inimigos[posicao] = new Entidade(atk, def, locx, locy);
    }
  }

  ///Imprime os atributos do objeto. Feito para debug.
  public void imprimirSetor()
  {
    System.out.printf("PAREDE EM CIMA: %b %nPAREDE EMBAIXO: %b %nPAREDE NA ESQUERDA: %b %nPAREDE NA DIREITA: %b %nTIPO: %d %n %n", this.getparedecima(), this.getparedebaixo(), this.getparedeesq(), this.getparededir(), this.gettiposetor());
  }
}