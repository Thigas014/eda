import java.util.Scanner;

class Nodo {
    int valor;       //nodo
    Nodo prox;       //próximo nodo
    Nodo ant;        //nodo anterior

    //inicializar o nodo com um valor
    public Nodo(int valor) {
        this.valor = valor;
        this.prox = null;
        this.ant = null;
    }
}

class ListaEncadeada {
    private Nodo primeiro;  //primeiro nodo
    private Nodo ultimo;    //último nodo
    private int tamanho;    //Tamanho da lista

    //inicializa a lista vazia
    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    //Retorna o tamanho da lista
    public int size() {
        return tamanho;
    }

    // Adiciona um elemento no final da lista
    public void addFinal(int elemento) {
        Nodo novoNodo = new Nodo(elemento);

        if (primeiro == null) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            ultimo.prox = novoNodo;
            novoNodo.ant = ultimo;
            ultimo = novoNodo;
        }
        tamanho++;
    }

    // Adiciona um elemento no início da lista
    public void addComeco(int elemento) {
        Nodo novoNodo = new Nodo(elemento);

        if (primeiro == null) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            novoNodo.prox = primeiro;
            primeiro.ant = novoNodo;
            primeiro = novoNodo;
        }
        tamanho++;
    }

    // Adiciona um elemento na posição especificada
    public void add(int index, int elemento) {
        if (index < 0 || index > tamanho) { //excecçao
            throw new IndexOutOfBoundsException("Índice " + index + " fora dos limites da lista.");
        }

        // Se for adicionar no início
        if (index == 0) {
            addComeco(elemento);
            return;
        }

        // Se for adicionar no final
        if (index == tamanho) {
            addFinal(elemento);
            return;
        }

        //adiciona no meio
        Nodo novoNodo = new Nodo(elemento);
        Nodo atual = primeiro;

        for (int i = 0; i < index; i++) {
            atual = atual.prox;
        }

        novoNodo.prox = atual;
        novoNodo.ant = atual.ant;
        atual.ant.prox = novoNodo;
        atual.ant = novoNodo;

        tamanho++;
    }

    // Remove o elemento na posição especificada
    public void remove(int index) {
        if (index < 0 || index >= tamanho) { //exceçao
            throw new IndexOutOfBoundsException("Índice " + index + " fora dos limites da lista.");
        }

        // Se for remover o primeiro elemento
        if (index == 0) {
            if (primeiro.prox != null) {
                primeiro.prox.ant = null;
            } else {
                ultimo = null;
            }
            primeiro = primeiro.prox;
        } else if (index == tamanho - 1) {
            // Se for remover o último elemento
            ultimo = ultimo.ant;
            ultimo.prox = null;
        } else {
            // elemento no meio
            Nodo atual = primeiro;
            for (int i = 0; i < index; i++) {
                atual = atual.prox;
            }
            atual.ant.prox = atual.prox;
            if (atual.prox != null) {
                atual.prox.ant = atual.ant;
            }
        }

        tamanho--;
    }

    // Exibe todos os elementos da lista
    public void exibirLista() {
        Nodo atual = primeiro;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.prox;
        }
        System.out.println();
    }
}

public class ListaDuplamenteEncadeada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEncadeada lista = new ListaEncadeada();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar elemento no final");
            System.out.println("2. Adicionar elemento no começo");
            System.out.println("3. Adicionar elemento em uma posição");
            System.out.println("4. Remover elemento por índice");
            System.out.println("5. Exibir lista");
            System.out.println("6. Exibir tamanho da lista");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser adicionado: ");
                    int valor = scanner.nextInt();
                    lista.addFinal(valor);
                    System.out.println("Elemento " + valor + " adicionado ao final da lista.");
                    break;

                case 2:
                    System.out.print("Digite o valor a ser adicionado: ");
                    valor = scanner.nextInt();
                    lista.addComeco(valor);
                    System.out.println("Elemento " + valor + " adicionado ao começo da lista.");
                    break;

                case 3:
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
