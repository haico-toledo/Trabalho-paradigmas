public class Entidade {
  protected int atk;
  protected int def;
  protected int locx;
  protected int locy;

  public Entidade() {
  }

  public Entidade(int atk, int def, int locx, int locy) {
    this.setAtk(atk);
    this.setDef(def);
    this.setLocx(locx);
    this.setLocy(locy);
  }

  public int getAtk() {
    return this.atk;
  }

  public void setAtk(int atk) {
    if (atk > 0) {
      this.atk = atk;
    }
  }

  public int getDef() {
    return this.def;
  }

  public void setDef(int def) {
    if (def < 0) {
      this.def = 0;
    } else {
      this.def = def;
    }
  }

  public int getLocx() {
    return this.locx;
  }

  public void setLocx(int locx) {
    if (locx >= 0) {
      this.locx = locx;
    }
  }

  public int getLocy() {
    return this.locy;
  }

  public void setLocy(int locy) {
    if (locy >= 0) {
      this.locy = locy;
    }
  }

  /// Subtrai o próprio atk do alvo.
  public void atacar(Entidade alvo) {
    if (alvo != null) {
      int dano = this.getAtk();
      alvo.setDef(alvo.getDef() - dano);
    }
  }

  /// Retorna, em forma de String, atk e def.
  public String resumoAtributos() {
    return "%d/%d".formatted(this.atk, this.def);
  }
}