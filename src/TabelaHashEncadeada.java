import java.util.Scanner;

class Nodo {
    Aluno valor;
    Nodo prox;

    public Nodo(Aluno valor) {
        this.valor = valor;
        this.prox = null;
    }
}

// Classe Aluno
class Aluno {
    int matricula;
    String nome;

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }
}

class ListaEncadeada {
    private Nodo primeiro;
    private int tamanho;

    public ListaEncadeada() {
        this.primeiro = null;
        this.tamanho = 0;
    }

    public int size() {
        return tamanho;
    }

    public void add(Aluno aluno) {
        Nodo novoNodo = new Nodo(aluno);

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

    public Aluno get(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice " + index + " fora dos limites da lista.");
        }
        Nodo atual = primeiro;
        for (int i = 0; i < index; i++) {
            atual = atual.prox;
        }
        return (Aluno) atual.valor;
    }

    public void remove(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice " + index + " fora dos limites da lista.");
        }
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
            Aluno aluno = (Aluno) atual.valor;
            System.out.print("Matrícula: " + aluno.matricula + " Nome: " + aluno.nome + " | ");
            atual = atual.prox;
        }
        System.out.println();
    }
}

class TabelaHash {
    private ListaEncadeada[] tabela;
    private int capacidade;

    public TabelaHash(int capacidade) {
        this.capacidade = capacidade;
        tabela = new ListaEncadeada[capacidade];
        for (int i = 0; i < capacidade; i++) {
            tabela[i] = new ListaEncadeada();
        }
    }

    // Função de cálculo do hash
    private int calcularHash(int matricula) {
        return matricula % capacidade;
    }

    // Função para pegar o valor (nome) pela matrícula
    public String pegarValor(int matricula) {
        int indice = calcularHash(matricula);
        ListaEncadeada lista = tabela[indice];
        for (int i = 0; i < lista.size(); i++) {
            Aluno aluno = lista.get(i);
            if (aluno.matricula == matricula) {
                return aluno.nome;
            }
        }
        return null;
    }

    // Função para inserir valor (aluno)
    public void inserirValor(int matricula, String nome) {
        Aluno aluno = new Aluno(matricula, nome);
        int indice = calcularHash(matricula);
        tabela[indice].add(aluno);
    }

    // Função para remover valor (aluno)
    public void removerValor(int matricula) {
        int indice = calcularHash(matricula);
        ListaEncadeada lista = tabela[indice];
        for (int i = 0; i < lista.size(); i++) {
            Aluno aluno = lista.get(i);
            if (aluno.matricula == matricula) {
                lista.remove(i);
                break;
            }
        }
    }

    // Função para exibir a tabela
    public void exibirTabela() {
        for (int i = 0; i < capacidade; i++) {
            System.out.print("Índice " + i + ": ");
            tabela[i].exibirLista();
        }
    }
}

public class TabelaHashEncadeada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TabelaHash tabelaHash = new TabelaHash(10);  // Tamanho da tabela hash é 10

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Inserir aluno");
            System.out.println("2. Buscar aluno por matrícula");
            System.out.println("3. Remover aluno por matrícula");
            System.out.println("4. Exibir tabela hash");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // nome ta aceitando ser numero
                    System.out.print("Digite a matrícula do aluno: ");
                    int matricula = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o nome do aluno: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine();
                    tabelaHash.inserirValor(matricula, nome);
                    System.out.println("Aluno " + nome + " inserido.");
                    break;

                case 2:
                    System.out.print("Digite a matrícula para buscar: ");
                    matricula = scanner.nextInt();
                    String alunoNome = tabelaHash.pegarValor(matricula);
                    if (alunoNome != null) {
                        System.out.println("Aluno encontrado: " + alunoNome);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Digite a matrícula para remover: ");
                    matricula = scanner.nextInt();

                    // Tenta buscar o nome do aluno pela matrícula antes de remover
                    String nomeAluno = tabelaHash.pegarValor(matricula);

                    if (nomeAluno != null) {
                        // Remove o aluno da tabela hash
                        tabelaHash.removerValor(matricula);
                        System.out.printf("Aluno com a matrícula %d de nome %s foi removido.%n", matricula, nomeAluno);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Tabela Hash:");
                    tabelaHash.exibirTabela();
                    break;

                case 5:
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
