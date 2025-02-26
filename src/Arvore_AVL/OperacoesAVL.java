package Arvore_AVL;

public class OperacoesAVL {
    public static int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    public static int fatorBalanceamento(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.esquerdo) - altura(nodo.direito);
    }

    public static Nodo encontrarMenorValor(Nodo nodo) {
        while (nodo.esquerdo != null) {
            nodo = nodo.esquerdo;
        }
        return nodo;
    }
}