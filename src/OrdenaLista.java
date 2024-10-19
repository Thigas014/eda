import java.util.ArrayList;

public class OrdenaLista {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(4);
        numeros.add(3);
        numeros.add(2);
        numeros.add(1);
        System.out.println(numeros);


        int n = numeros.size();
        for (int i = 0; i < n -1; i++){
            for (int j =0; j < n- i- 1; j++){
                if(numeros.get(j) > numeros.get(j +1)){
                    int toca = numeros.get(j);
                    numeros.set(j, numeros.get(j +1));
                    numeros.set(j +1, toca);
                }
            }
        }
        System.out.println("lista ordenada");
        for(int num: numeros){
            System.out.println(num + " ");
        }
    }
}
