public abstract class Entidade
{
  ///As classes JogadorN, JogadorS e Virus herdam dessa classe abstrata.
  ///Ou  seja, objetos dessas classes podem usar os metodos de Entidade.
  ///Como tanto os jogadores quanto os Virus têm atk, def, locx e locy, faz sentido ter essa classe para não repetir código.
  protected int atk;
  protected int def;
  protected int locx;
  protected int locy;

  public Entidade() {}

  public Entidade(int atk, int def, int locx, int locy)
  {
    this.setatk(atk);
    this.setdef(def);
    this.setlocx(locx);
    this.setlocy(locy);
  }

  public int getatk()
  {
    return this.atk;
  }
  public void setatk(int novo_atk)
  {
    if (novo_atk > 0)
    {
      this.atk = novo_atk;
    }
  }

  public int getdef()
  {
    return this.def;
  }
  public void setdef(int nova_def)
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

  public int getlocx()
  {
    return this.locx;
  }
  public void setlocx(int nova_locx)
  {
    if (nova_locx >= 0)
    {
      this.locx = nova_locx;
    }
  }

  public int getlocy()
  {
    return this.locy;
  }
  public void setlocy(int nova_locy)
  {
    if (nova_locy >= 0)
    {
      this.locy = nova_locy;
    }
  }

  ///Feito pra debug, remover depois.
  public void imprimirAtributos()
  {
    System.out.printf("ATK: %d %nDEF: %d %nLOCX: %d %nLOCY: %d %n", this.getatk(), this.getdef(), this.getlocx(), this.getlocy());
  }
}