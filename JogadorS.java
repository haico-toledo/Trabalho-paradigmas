public class JogadorS extends JogadorN {

  public JogadorS(int atk, int def, int locx, int locy) {
    super(atk, def, locx, locy);
  }

  /// Soma 2 a defesa do alvo.
  /// retorna 1 se a vida foi recuperada e 0 c.c.
  public int recuperarDef(Entidade alvo) {
    int locxP2 = this.getLocx();
    int locyP2 = this.getLocy();
    int locxAlvo = alvo.getLocx();
    int locyAlvo = alvo.getLocy();
    boolean juntos = (locxP2 == locxAlvo && locyP2 == locyAlvo);
    if ((alvo instanceof JogadorN || alvo instanceof JogadorS) && (juntos)) {
      alvo.setDef(alvo.getDef() + 2);
      return 1;
    }
    return 0;
  }
}