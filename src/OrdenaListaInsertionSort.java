import java.util.ArrayList;


public class OrdenaListaInsertionSort {
    public static void insertionSort(ArrayList<Integer> lista) {
        for (int i = 1; i < lista.size(); i++) {
            int chave = lista.get(i);
            int j = i - 1;

            while (j >= 0 && lista.get(j) > chave) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }
            lista.set(j + 1, chave);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(4);
        lista.add(3);
        lista.add(2);
        lista.add(1);

        System.out.println("Lista original: " + lista);

        insertionSort(lista);

        System.out.println("Lista ordenada: " + lista);
    }
}
