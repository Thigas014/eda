public class Main {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash(10);

       
        tabelaHash.inserirValor(new Aluno(123, "Thiago"));
        tabelaHash.inserirValor(new Aluno(422, "Vinicius"));
        tabelaHash.inserirValor(new Aluno(689, "Raykkoner"));
        tabelaHash.inserirValor(new Aluno(122, "Joao"));
       
       
        System.out.println("~~~~~~~~~~ Tabela Hash apos inserções ~~~~~~~~~~~~");
        System.out.println(tabelaHash.imprimirTabela());


        tabelaHash.inserirValor(new Aluno(7, "Emerson"));
        tabelaHash.inserirValor(new Aluno(27, "Toin"));
        tabelaHash.inserirValor(new Aluno(47, "Renata"));
        
        System.out.println("~~~~~~~~ Tabela Hash apos adicionar alunos e redimensionar ~~~~~~~~~~");
        System.out.println(tabelaHash.imprimirTabela());

        tabelaHash.removerValor(89);
        System.out.println("~~~~~~~~ Tabela Hash apos remorção ~~~~~~~~");
        System.out.println(tabelaHash.imprimirTabela());
    }
}