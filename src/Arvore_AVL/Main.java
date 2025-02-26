package Arvore_AVL;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();
        Nodo raiz = new Nodo(30);
        raiz.direito = new Nodo(40);
        raiz.esquerdo = new Nodo(20);
        raiz = RotacoesAVL.rotacaoEsquerda(raiz);
        System.out.println("Após rotação esquerda: Raiz: " + raiz.chave);

        raiz = RotacoesAVL.rotacaoDireita(raiz);
        System.out.println("Após rotação direita: Raiz: " + raiz.chave);

        System.out.println("Fator de Balanceamento da raiz: " + OperacoesAVL.fatorBalanceamento(raiz));
        System.out.println("Altura da raiz: " + OperacoesAVL.altura(raiz));
        
        raiz = arvore.remover(raiz, 40);
        if (raiz != null) {
            System.out.println("Após remover 40: Raiz: " + raiz.chave);
        } else {
            System.out.println("Após remover 40: Raiz é null");
        }
    }
}
