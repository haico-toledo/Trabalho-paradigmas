import java.util.*;

public class Entrada {
    
    private Scanner teclado;

    //construtor
    public Entrada() {
        this.setTeclado();
    }

    //metodos get
    public Scanner getTeclado() {
        return this.teclado;
    }

    //metodos set
    public void setTeclado() {
        this.teclado = new Scanner(System.in);
    }

    //le o primeiro caractere de uma entrada
    public char lerEntrada()
    {
        char tecla = teclado.next().charAt(0);
        while (tecla == '\n') {
        tecla = teclado.next().charAt(0);
        }

        return Character.toLowerCase(tecla);
    }

    ///Lê um int e o retorna. Ao final da função o buffer de entrada é limpo.
    /// Não verifica entradas inválidas.
    public int LerInt()
    {
      int retorno = teclado.nextInt();
      teclado.nextLine();
      return retorno;
    }
}