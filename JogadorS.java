public class JogadorS extends JogadorN
{

  public JogadorS(int atk, int def, int locx, int locy)
  {
    super(atk, def, locx, locy);
  }

  ///Soma 2 a defesa do alvo.
  /// retorna 1 se a vida foi recuperada e 0 c.c.
  public int recuperarDef(Entidade alvo)
  {
    int locxp2 = this.getLocx();
    int locyp2 = this.getLocy();
    int locxalvo = alvo.getLocx();
    int locyalvo = alvo.getLocy();
    boolean juntos = (locxp2 == locxalvo && locyp2 == locyalvo);
    if ((alvo instanceof JogadorN || alvo instanceof JogadorS) && (juntos))
    {
      alvo.setDef(alvo.getDef() + 2);
      return 1;
    }
    return 0;
  }
}