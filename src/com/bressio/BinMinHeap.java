package com.bressio;

public class BinMinHeap {
    private int n; /* Numero de elementos no heap */
    private int tam; /* Tamanho do heap */
    private	Arvbin[] vetor; /* Vetor com elementos */

    /* Constrói heap vazio a partir dos elementos (caracteres). */
    public BinMinHeap(int tamanho) {
        n = 0;
        tam = tamanho;
        vetor = new Arvbin[tamanho+1];
    }

    /* Testa se a heap está vazia. */
    public boolean vazia() {
        /* O grupo deve preencher a implementação. */
        return false;
    }

    /* Refaz a condição de heap (heapify). */
    public void refaz(int i) {
        /* O grupo deve preencher a implementação. */
    }

    /* Constrói a heap (build heap). */
    public void constroiHeap() {
        /* O grupo deve preencher a implementação. */
    }

    /* Lê dados via teclado e insere na heap. */
    public void carregaDados() {
        int errors = 0;
        for (int i = 0; i < tam + errors; i++) {
            StringFormat.printInputDialog(
                    "Digite o símbolo e a frequência" +
                            " (" + (i + 1 - errors) + "/" + tam + ")");
            String input = StringIO.getInstance().textInput();
            if (StringFormat.isValid(input)) {
                vetor[i + 1 - errors] = new Arvbin(StringFormat.getChar(input), StringFormat.getInt(input));
            } else {
                StringFormat.printError("Você digitou uma entrada inválida");
                System.out.println();
                errors++;
            }
        }
        constroiHeap();
    }

    /* Executa o algoritmo de Huffman. */
    public void aplicaHuffman() {
        /* O grupo deve preencher a implementação. */
    }

    /* Chama o método mostra códigos da classe Arvbin. */
    public void mostraCodigos() {
        /* O grupo deve preencher a implementação. */
    }

    /* Insere x na heap. */
    public void insere(Arvbin x) {
        /* O grupo deve preencher a implementação. */
    }

    /* Remove e retorna o menor item. */
    public Arvbin removeMin() {
        /* O grupo deve preencher a implementação. */
        return null;
    }

    /* Imprime o conteúdo da heap. */
    public void imprime() {
        /* O grupo deve preencher a implementação. */
    }
}
