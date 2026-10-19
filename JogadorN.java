public class JogadorN extends Entidade
{

  public JogadorN(int atk, int def, int locx, int locy)
  {
    super(atk, def, locx, locy);
  }
  
  ///Dado um Virus, ataca ele.
  public void atacarVirus(Virus alvo)
  {
    int dano = this.getatk();
    alvo.setdef(alvo.getdef() - dano);
  }
  
  ///Ação de procurar, ainda não feita.
  public void procurar() 
  {
    ///Implementação aqui. 
  }
}