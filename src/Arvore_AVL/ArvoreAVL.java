package Arvore_AVL;
public class ArvoreAVL {
    private Nodo balancear(Nodo nodo) {
        int fb = OperacoesAVL.fatorBalanceamento(nodo);

        if (fb > 1 && OperacoesAVL.fatorBalanceamento(nodo.esquerdo) >= 0) {
            return RotacoesAVL.rotacaoDireita(nodo);
        }

        if (fb < -1 && OperacoesAVL.fatorBalanceamento(nodo.direito) <= 0) {
            return RotacoesAVL.rotacaoEsquerda(nodo);
        }

        if (fb > 1 && OperacoesAVL.fatorBalanceamento(nodo.esquerdo) < 0) {
            nodo.esquerdo = RotacoesAVL.rotacaoEsquerda(nodo.esquerdo);
            return RotacoesAVL.rotacaoDireita(nodo);
        }

        if (fb < -1 && OperacoesAVL.fatorBalanceamento(nodo.direito) > 0) {
            nodo.direito = RotacoesAVL.rotacaoDireita(nodo.direito);
            return RotacoesAVL.rotacaoEsquerda(nodo);
        }

        return nodo;
    }

    public Nodo remover(Nodo raiz, int chave) {
        if (raiz == null) {
            return raiz;
        }

        if (chave < raiz.chave) {
            raiz.esquerdo = remover(raiz.esquerdo, chave);
        } else if (chave > raiz.chave) {
            raiz.direito = remover(raiz.direito, chave);
        } else {
            Nodo temp;
            if (raiz.esquerdo == null) {
                temp = raiz.direito;
                raiz = temp;
            } else if (raiz.direito == null) {
                temp = raiz.esquerdo;
                raiz = temp;
            } else {
                temp = OperacoesAVL.encontrarMenorValor(raiz.direito);
                raiz.chave = temp.chave;
                raiz.direito = remover(raiz.direito, temp.chave);
            }
        }

        if (raiz == null) {
            return raiz;
        }

        raiz.altura = Math.max(OperacoesAVL.altura(raiz.esquerdo), OperacoesAVL.altura(raiz.direito)) + 1;
        return balancear(raiz);
    }
}