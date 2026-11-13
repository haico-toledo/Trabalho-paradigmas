import java.util.*;

public class Entrada {

    private Scanner teclado;

    // construtor
    public Entrada() {
        this.setTeclado();
    }

    // metodos get
    public Scanner getTeclado() {
        return this.teclado;
    }

    // metodos set
    public void setTeclado() {
        this.teclado = new Scanner(System.in);
    }

    /// Retorna o primeiro caracter da entrada dada.
    public char lerEntrada() {
        char tecla = teclado.next().charAt(0);
        while (tecla == '\n') {
            tecla = teclado.next().charAt(0);
        }

        return Character.toLowerCase(tecla);
    }

    /// Lê um char e retorna o valor númerico dele.
    /// Se digitar '1', o método retorna 1.
    public int lerNumero() {
        char retorno = this.lerEntrada();
        teclado.nextLine();
        return Character.getNumericValue(retorno);
    }
}