import java.util.Random;

public class JogadorN extends Entidade {

  public JogadorN(int atk, int def, int locx, int locy) {
    super(atk, def, locx, locy);
  }

  /// Ação de procurar.
  /// Deve receber o vetor de Inimigos já alocado, com inimigos instanciados
  /// e o tamanho do vetor de inimigos. Retorna -1 caso recupere 1 de DEF, -2 caso
  /// recupere 2 de DEF, -3 caso não aconteça nada, -4 caso não haja inimigos no
  /// setor (e caia no caso numero == 6).
  /// Retorna o novo tamanho do vetor caso os inimigos sejam danificados.
  public int procurar(Setor setor) {
    Random aleatorio = new Random();
    int numero = aleatorio.nextInt(6) + 1;
    if (numero == 4) {
      this.setDef(this.getDef() + 1);
      return -1;
    } else if (numero == 5) {
      this.setDef(this.getDef() + 2);
      return -2;
    } else if (numero == 6) {
      Entidade[] vetor = setor.getInimigos();
      int qtd_inimigos = setor.getQtdInimigos();
      if (qtd_inimigos <= 0) {
        return -4;
      }
      Entidade inimigo;
      int x;
      for (x = 0; x < qtd_inimigos; x++) {
        inimigo = setor.getInimigo(x);
        if (inimigo != null && inimigo.getDef() > 0) {
          inimigo.setDef(inimigo.getDef() - 1);
        }
      }

      x = 0;
      while (x < setor.getQtdInimigos()) {
        inimigo = setor.getInimigo(x);
        if (inimigo.getDef() <= 0) {
          for (int y = x; y < setor.getQtdInimigos() - 1; y++) {
            vetor[y] = vetor[y + 1];
          }
          setor.setQtdInimigos(setor.getQtdInimigos() - 1);
        }
        if (setor.getInimigo(x).getDef() > 0)
          x++;
      }
      return setor.getQtdInimigos();
    }
    return -3;
  }
}