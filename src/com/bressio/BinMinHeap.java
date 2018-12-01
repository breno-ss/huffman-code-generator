package com.bressio;

public class BinMinHeap {
    private int n; /* Numero de elementos no heap */
    private int tam; /* Tamanho do heap */
    private	Arvbin[] vetor; /* Vetor com elementos */

    /* Constrói heap vazio a partir dos elementos (caracteres). */
    public BinMinHeap(int tamanho) {
        n = tamanho;
        tam = tamanho;
        vetor = new Arvbin[tamanho+1];
    }

    /* Testa se a heap está vazia. */
    public boolean vazia() {
        return n == 0;
    }

    /* Refaz a condição de heap (heapify). */
    public void refaz(int i) {
        Arvbin x = vetor[i];

        while (2 * i <= n) {
            int leftmostChild = 2 * i;
            int rightmostChild = (2 * i) + 1;
            int smallestChild = leftmostChild;

            if ((leftmostChild != n) && (vetor[rightmostChild].compareTo(vetor[leftmostChild]) < 0)) {
                smallestChild = rightmostChild;
            }
            
            if (vetor[smallestChild].compareTo(x) < 0) {
                vetor [i] = vetor[smallestChild];
            } else {
                break;
            }

            i = smallestChild;
        }

        vetor[i] = x;
    }

    /* Constrói a heap (build heap). */
    public void constroiHeap() {
        for( int i = n / 2; i > 0; i-- )
            refaz(i);
    }

    /* Lê dados via teclado e insere na heap. */
    public void carregaDados() {
        int errors = 0;
        for (int i = 0; i < tam + errors; i++) {
            StringOut.printInputDialog(
                    "Digite o símbolo e a frequência" +
                            " (" + (i + 1 - errors) + "/" + tam + ")");
            String input = StringIn.getInstance().textInput();
            if (StringFormat.isValid(input)) {
                vetor[i + 1 - errors] = new Arvbin(StringFormat.getChar(input), StringFormat.getInt(input));
            } else {
                StringOut.printError("Você digitou uma entrada inválida");
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
        Arvbin smallestElement;

        if(this.vazia()) {
            StringOut.printError("Fila de prioridades vazia!");
            return null;
        }

        smallestElement = vetor[1];
        vetor[1] = vetor[n];
        n--;
        refaz(1);

        return smallestElement;
    }

    /* Imprime o conteúdo da heap. */
    public void imprime() {
//        TODO: Melhorar a formatação da árvore

        StringOut.printBlock("Representação em árvore:");

        int s = n;
        String offset = StringFormat.repeat(" ", s);
        int count = 0;
        while (count <= Math.sqrt(n)) {
            StringOut.printInline(offset);
            if (count == 0) {
                StringOut.printInline(vetor[1].toString());
            } else {
                for (int i = (int) Math.pow(2, count); i <= Math.pow(2, count + 1) - 1; i++) {
                    if (i <= n) {
                        StringOut.printInline(vetor[i].toString() + " ");
                    }
                }
            }
            s = (int) (s / 1.75);
            offset = StringFormat.repeat(" ", s);
            count++;
            StringOut.printBlock("\n");
        }

        StringOut.printBlock("Representação em lista:");
        StringOut.printBlock("(index) [símbolo | frequência]");

        for(int i = 1; i <= n; i++) {
            StringOut.printBlock("(" + i + ") " + vetor[i].toString() + " ");
        }
    }
}
