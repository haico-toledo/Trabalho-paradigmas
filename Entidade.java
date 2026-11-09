public class Entidade
{
  protected int atk;
  protected int def;
  protected int locx;
  protected int locy;

  public Entidade() {}

  public Entidade(int atk, int def, int locx, int locy)
  {
    this.setAtk(atk);
    this.setDef(def);
    this.setLocx(locx);
    this.setLocy(locy);
  }

  public int getAtk()
  {
    return this.atk;
  }
  public void setAtk(int novo_atk)
  {
    if (novo_atk > 0)
    {
      this.atk = novo_atk;
    }
  }

  public int getDef()
  {
    return this.def;
  }
  public void setDef(int nova_def)
  {
    if (nova_def < 0)
    {
      this.def = 0;
    }
    else
    {
      this.def = nova_def;
    }
  }

  public int getLocx()
  {
    return this.locx;
  }
  public void setLocx(int nova_locx)
  {
    if (nova_locx >= 0)
    {
      this.locx = nova_locx;
    }
  }

  public int getLocy()
  {
    return this.locy;
  }
  public void setLocy(int nova_locy)
  {
    if (nova_locy >= 0)
    {
      this.locy = nova_locy;
    }
  }

  public void atacar(Entidade alvo)
  {
    if (alvo != null)
    {
     int dano = this.getAtk();
     alvo.setDef(alvo.getDef() - dano);
    }
  }

  public String resumoAtributos()
  {
    return "%d/%d".formatted(this.atk, this.def);
  }
}