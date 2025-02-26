package Arvore_AVL;

class Nodo {
    int chave;
    int altura;
    Nodo esquerdo;
    Nodo direito;

    public Nodo(int chave) {
        this.chave = chave;
        this.altura = 1;
    }
}
