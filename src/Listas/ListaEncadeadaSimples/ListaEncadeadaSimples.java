package Listas.ListaEncadeadaSimples;

import java.util.Scanner;
class Nodo {
    int valor;
    Nodo prox;


    public Nodo(int valor) {
        this.valor = valor;
        this.prox = null;
    }
}


class ListaEncadeada {
    private Nodo primeiro;  // Referência para o primeiro nodo
    private int tamanho;    // Tamanho da lista

    public ListaEncadeada() {
        this.primeiro = null;
        this.tamanho = 0;
    }

    // Retorna o tamanho da lista
    public int size() {
        return tamanho;
    }

    // Adiciona um elemento no final da lista
    public void add(int elemento) {
        Nodo novoNodo = new Nodo(elemento);

        if (primeiro == null) {
            primeiro = novoNodo;
        } else {
            Nodo atual = primeiro;
            while (atual.prox != null) {
                atual = atual.prox;
            }
            atual.prox = novoNodo;
        }
        tamanho++;
    }

    // Retorna o nodo na posição especificada ou excessao se não existir
    public Nodo get(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice " + index + " fora dos limites da lista.");
        }
        Nodo atual = primeiro;
        for (int i = 0; i < index; i++) {
            atual = atual.prox;
        }
        return atual;
    }

    // Adiciona um elemento em uma posição específica
    public void add(int index, int elemento) {
        if (index < 0 || index > tamanho) {
            throw new IndexOutOfBoundsException("Índice " + index + " está fora dos limites da lista.");
        }

        Nodo novoNodo = new Nodo(elemento);

        // Se for no início da lista
        if (index == 0) {
            novoNodo.prox = primeiro;
            primeiro = novoNodo;
        } else {
            Nodo atual = primeiro;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.prox;
            }
            novoNodo.prox = atual.prox;
            atual.prox = novoNodo;
        }
        tamanho++;
    }

    // Remove o elemento na posição especificada
    public void remove(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice " + index + " fora dos limites da lista.");
        }

        // Se for o primeiro elemento
        if (index == 0) {
            primeiro = primeiro.prox;
        } else {
            Nodo atual = primeiro;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.prox;
            }
            atual.prox = atual.prox.prox;
        }
        tamanho--;
    }

    public void exibirLista() {
        Nodo atual = primeiro;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.prox;
        }
        System.out.println();
    }
}

public class ListaEncadeadaSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEncadeada lista = new ListaEncadeada();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar elemento no final");
            System.out.println("2. Adicionar elemento em uma posição");
            System.out.println("3. Obter elemento por índice");
            System.out.println("4. Remover elemento por índice");
            System.out.println("5. Exibir lista");
            System.out.println("6. Exibir tamanho da lista");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser adicionado: ");
                    int valor = scanner.nextInt();
                    lista.add(valor);
                    System.out.println("Elemento " + valor + " adicionado ao final da lista.");
                    break;

                case 2:
                    System.out.print("Digite a posição para adicionar: ");
                    int posicao = scanner.nextInt();
                    System.out.print("Digite o valor a ser adicionado: ");
                    valor = scanner.nextInt();
                    try {
                        lista.add(posicao, valor);
                        System.out.println("Elemento " + valor + " adicionado na posição " + posicao);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Digite a posição para obter o valor: ");
                    posicao = scanner.nextInt();
                    try {
                        Nodo nodo = lista.get(posicao);
                        System.out.println("Elemento na posição " + posicao + ": " + nodo.valor);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Digite a posição para remover o valor: ");
                    posicao = scanner.nextInt();
                    try {
                        lista.remove(posicao);
                        System.out.println("Elemento na posição " + posicao + " removido.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Lista atual:");
                    lista.exibirLista();
                    break;

                case 6:
                    System.out.println("Tamanho da lista: " + lista.size());
                    break;

                case 7:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}