import java.util.ArrayList;
import java.util.Scanner;

//iterativa
public class AcharNListaIntearativa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(4);
        lista.add(3);
        lista.add(2);
        lista.add(1);
        System.out.println(lista);

        System.out.println("colocar numero");
        int vericar = sc.nextInt();

        boolean achar = false;
        for(int numero : lista){
            if(numero == vericar){
                achar = true;
                break;
            }
        }
        if(achar){
            System.out.println("o numero " + vericar + " ta na lista");
        }
        else{
            System.out.println("O numero " + vericar + " não ta na lista");
        }
    }
}