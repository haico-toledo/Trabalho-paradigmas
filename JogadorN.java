import java.util.Random;

public class JogadorN extends Entidade
{

  public JogadorN(int atk, int def, int locx, int locy)
  {
    super(atk, def, locx, locy);
  }
  
  ///Ação de procurar.
  /// Deve receber o vetor de Inimigos já alocado e com inimigos instanciados
  /// e o tamanho do vetor de inimigos.
  public void procurar(Setor setor_atual, int qtd_inimigos) 
  {
    Random aleatorio = new Random();
    int numero = aleatorio.nextInt(6);
    if (numero == 4)
    {
      this.setDef(this.getDef() + 1);
    }
    else if (numero == 5)
    {
      this.setDef(this.getDef() + 2);
    }
    else if (numero == 6)
    {
      int x;
      for (x = 0; x < qtd_inimigos; x++)
      {
        Entidade inimigo = setor_atual.getInimigo(x);
        if (inimigo != null && inimigo.getDef() > 0)
        {
          inimigo.setDef(inimigo.getDef() - 1);
        }
      }
    }
  }
}