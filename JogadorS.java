public class JogadorS extends JogadorN
{

  public JogadorS(int atk, int def, int locx, int locy)
  {
    super(atk, def, locx, locy);
  }

  ///Soma 2 a própria defesa.
  public void recuperarDef()
  {
    this.setdef(this.getdef() + 2);
  }

  ///Soma 2 a defesa do JogadorN dado como argumento.
  public void recuperarDef(JogadorN alvo)
  {
    alvo.setdef(alvo.getdef() + 2);
  }
}