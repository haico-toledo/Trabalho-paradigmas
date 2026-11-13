import java.util.Random;

public class Setor {
  private boolean paredeCima;
  private boolean paredeBaixo;
  private boolean paredeEsq;
  private boolean paredeDir;
  private boolean visitado;

  private int tipoSetor;
  private int qtdInimigos;

  private Entidade[] inimigos;

  public Setor(boolean paredeCima, boolean paredeBaixo, boolean paredeEsq, boolean paredeDir, int TipoSetor) {
    this.setParedeCima(paredeCima);
    this.setParedeBaixo(paredeBaixo);
    this.setParedeEsq(paredeEsq);
    this.setParedeDir(paredeDir);
    this.setTipoSetor(TipoSetor);
  }

  public boolean isParedeCima() {
    return this.paredeCima;
  }

  public void setParedeCima(boolean paredeCima) {
    this.paredeCima = paredeCima;
  }

  public boolean isParedeBaixo() {
    return this.paredeBaixo;
  }

  public void setParedeBaixo(boolean paredeBaixo) {
    this.paredeBaixo = paredeBaixo;
  }

  public boolean isParedeEsq() {
    return this.paredeEsq;
  }

  public void setParedeEsq(boolean paredeEsq) {
    this.paredeEsq = paredeEsq;
  }

  public boolean isParedeDir() {
    return this.paredeDir;
  }

  public void setParedeDir(boolean paredeDir) {
    this.paredeDir = paredeDir;
  }

  public boolean isVisitado() {
    return this.visitado;
  }

  public void setVisitado(boolean visitado) {
    if (this.visitado != true) {
      this.visitado = visitado;
    }
  }

  public int getTipoSetor() {
    return this.tipoSetor;
  }

  public void setTipoSetor(int TipoSetor) {
    if (TipoSetor >= 0 && TipoSetor < 3) {
      this.tipoSetor = TipoSetor;
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

  public int getQtdInimigos() {
    return this.qtdInimigos;
  }

  public void setQtdInimigos(int qtdInimigos) {
    if (qtdInimigos >= 0) {
      this.qtdInimigos = qtdInimigos;
    }
  }

  public Entidade getInimigo(int posicao) {
    return this.inimigos[posicao];
  }

  public void setInimigo(int posicao, Entidade novo) {
    if (posicao >= 0 && posicao < this.getQtdInimigos() && this.getInimigos() != null && novo != null) {
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