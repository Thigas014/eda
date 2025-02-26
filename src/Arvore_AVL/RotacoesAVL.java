package Arvore_AVL;

public class RotacoesAVL {
    public static Nodo rotacaoEsquerda(Nodo y) {
        Nodo x = y.direito;
        Nodo T2 = x.esquerdo;

        x.esquerdo = y;
        y.direito = T2;

        y.altura = Math.max(OperacoesAVL.altura(y.esquerdo), OperacoesAVL.altura(y.direito)) + 1;
        x.altura = Math.max(OperacoesAVL.altura(x.esquerdo), OperacoesAVL.altura(x.direito)) + 1;

        return x;
    }

    public static Nodo rotacaoDireita(Nodo x) {
        Nodo y = x.esquerdo;
        Nodo T2 = y.direito;

        y.direito = x;
        x.esquerdo = T2;

        x.altura = Math.max(OperacoesAVL.altura(x.esquerdo), OperacoesAVL.altura(x.direito)) + 1;
        y.altura = Math.max(OperacoesAVL.altura(y.esquerdo), OperacoesAVL.altura(y.direito)) + 1;

        return y;
    }
}