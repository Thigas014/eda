import java.util.ArrayList;
import java.util.List;

public class contarN2 {

    public static int iniciar(List<Integer> lista){
        return contarDois(lista, 0);
    }
    private static int contarDois(List<Integer> lista, int posicao) {
        if(posicao == lista.size()){ //base
            return 0;
        }

        int contagem = 0;
        if(lista.get(posicao) == 2){
            contagem =1;
        }

        return contagem + contarDois(lista, posicao+1);
    }

    public static void main(String[] args){
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(4);
        lista.add(3);
        lista.add(2);
        lista.add(1);
        System.out.println(lista);
        int teste = iniciar(lista);
        System.out.println("O número 2 aparece " + teste + " vezes na lista.");
    }
}
