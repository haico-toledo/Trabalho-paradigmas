import java.util.Random;

public class JogadorN extends Entidade
{

  public JogadorN(int atk, int def, int locx, int locy)
  {
    super(atk, def, locx, locy);
  }
  
  ///Ação de procurar.
  /// Deve receber o vetor de Inimigos já alocado e com inimigos instanciados
  /// e o tamanho do vetor de inimigos. Retorna -1 caso recupere 1 de DEF, -2 caso recupere 2 de DEF, -3 caso não aconteça nada, -4 caso não haja inimigos no setor
  /// e caia no caso numero == 6.
  /// Retorna o novo tamanho do vetor caso os inimigos sejam danificados.
  public int procurar(Setor setor_atual) 
  {
    Random aleatorio = new Random();
    int numero = aleatorio.nextInt(6) + 1;
    if (numero == 4)
    {
      this.setDef(this.getDef() + 1);
      return -1;
    }
    else if (numero == 5)
    {
      this.setDef(this.getDef() + 2);
      return -2;
    }
    else if (numero == 6)
    {
      Entidade[] vetor = setor_atual.getInimigos();
      int qtd_inimigos = setor_atual.getQtdinimigos();
      if (qtd_inimigos <= 0)
      {
        return -4;
      }
      Entidade inimigo;
      int x;
      for (x = 0; x < qtd_inimigos; x++)
      {
        inimigo = setor_atual.getInimigo(x);
        if (inimigo != null && inimigo.getDef() > 0)
        {
          inimigo.setDef(inimigo.getDef() - 1);
        }
      }

      x = 0;
      while (x < setor_atual.getQtdinimigos())
      {
        inimigo = setor_atual.getInimigo(x);
        if (inimigo.getDef() <= 0)
        {
          for(int y = x; y < setor_atual.getQtdinimigos() - 1; y++)
          {
            vetor[y] = vetor[y + 1];
          }
          setor_atual.setQtdinimigos(setor_atual.getQtdinimigos() - 1);
        }
        if (setor_atual.getInimigo(x).getDef() > 0)
          x++;
      }
      return setor_atual.getQtdinimigos();
    }
    return -3;
  }
}