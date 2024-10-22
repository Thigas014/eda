import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcharNListaRecursiva {
    public static boolean verificar(List<Integer> lista, int numero, int indice) {
        if (indice == lista.size()) {
            System.out.println("O número " + numero + " não está na lista.");
            return false;
        }
        if (lista.get(indice) == numero) {
            System.out.println("O número " + numero + " está na lista.");
            return true;
        }
        return verificar(lista, numero, indice + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(4);
        lista.add(3);
        lista.add(2);
        lista.add(1);
        System.out.println(lista);

        System.out.println("Coloque um número:");
        int verificarNumero = sc.nextInt();

        verificar(lista, verificarNumero, 0);
    }
}
