import java.util.Random;

public class Setor {
  private boolean paredecima;
  private boolean paredebaixo;
  private boolean paredeesq;
  private boolean parededir;
  private boolean visitado;

  private int tiposetor;
  private int qtdinimigos;

  private Entidade[] inimigos;

  public Setor(boolean paredecima, boolean paredebaixo, boolean paredeesq, boolean parededir, int tiposetor) {
    this.setParedecima(paredecima);
    this.setParedebaixo(paredebaixo);
    this.setParedeesq(paredeesq);
    this.setParededir(parededir);
    this.setTiposetor(tiposetor);
  }

  public boolean isParedecima() {
    return this.paredecima;
  }

  public void setParedecima(boolean paredecima) {
    this.paredecima = paredecima;
  }

  public boolean isParedebaixo() {
    return this.paredebaixo;
  }

  public void setParedebaixo(boolean paredebaixo) {
    this.paredebaixo = paredebaixo;
  }

  public boolean isParedeesq() {
    return this.paredeesq;
  }

  public void setParedeesq(boolean paredeesq) {
    this.paredeesq = paredeesq;
  }

  public boolean isParededir() {
    return this.parededir;
  }

  public void setParededir(boolean parededir) {
    this.parededir = parededir;
  }

  public boolean isVisitado() {
    return this.visitado;
  }

  public void setVisitado(boolean visitado) {
    if (this.visitado != true) {
      this.visitado = visitado;
    }
  }

  public int getTiposetor() {
    return this.tiposetor;
  }

  public void setTiposetor(int tiposetor) {
    if (tiposetor >= 0 && tiposetor < 3) {
      this.tiposetor = tiposetor;
    }
  }

  public Entidade[] getInimigos() {
    return this.inimigos;
  }

  public void setInimigos(Entidade[] inimigos) {
    if (inimigos != null) {
      this.inimigos = inimigos;
    }
  }

  public int getQtdinimigos() {
    return this.qtdinimigos;
  }

  public void setQtdinimigos(int qtdinimigos) {
    if (qtdinimigos >= 0) {
      this.qtdinimigos = qtdinimigos;
    }
  }

  public Entidade getInimigo(int posicao) {
    return this.inimigos[posicao];
  }

  public void setInimigo(int posicao, Entidade novo) {
    if (posicao >= 0 && posicao < this.getQtdinimigos() && this.getInimigos() != null && novo != null) {
      this.inimigos[posicao] = novo;
    }
  }

  /// Dado a posição do Inimigo no vetor de inimigos, o instancia.
  public void instanciarInimigo(int posicao, int atkdef_max, int locx, int locy) {
    Random aleatorio = new Random();
    int status = aleatorio.nextInt(atkdef_max) + 1;
    if (this.getInimigos() != null) {
      this.setInimigo(posicao, new Entidade(status, status, locx, locy));
    }
  }
}