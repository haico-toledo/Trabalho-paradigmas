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
      this.setdef(this.getdef() + 1);
    }
    else if (numero == 5)
    {
      this.setdef(this.getdef() + 2);
    }
    else if (numero == 6)
    {
      int x;
      for (x = 0; x < qtd_inimigos; x++)
      {
        Entidade inimigo = setor_atual.getinimigo(x);
        if (inimigo != null && inimigo.getdef() > 0)
        {
          inimigo.setdef(inimigo.getdef() - 1);
        }
      }
    }
  }
}