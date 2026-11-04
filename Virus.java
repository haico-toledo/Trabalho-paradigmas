public class Virus extends Entidade
{
   
  public Virus(int atk, int def, int locx, int locy)
  {
    super(atk, def, locx, locy);
  }

  //Recebe um alvo e subtrai o atk do vírus da vida do mesmo. 
  ///Feita para o P1 (JogadorN)
  public void atacarJogador(JogadorN alvo)
  {
    int dano = this.getAtk();
    alvo.setDef(alvo.getDef() - dano);
  }
  
  ///Recebe um alvo e subtrai o atk do vírus da vida do mesmo.
  ///Feita para o P2 (JogadorS)
  public void atacarJogador(JogadorS alvo)
  {
    int dano = this.getAtk();
    alvo.setDef(alvo.getDef() - dano);
  }
}