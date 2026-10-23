public class JogadorS extends JogadorN
{

  public JogadorS(int atk, int def, int locx, int locy)
  {
    super(atk, def, locx, locy);
  }

  ///Soma 2 a defesa do alvo.
  public void recuperarDef(Entidade alvo)
  {
    if (alvo instanceof JogadorN || alvo instanceof JogadorS)
    {
      alvo.setdef(alvo.getdef() + 2);
    }
  }
}