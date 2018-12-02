package com.bressio;

public class BinMinHeap {
    private int n; /* Numero de elementos no heap */
    private int tam; /* Tamanho do heap */
    private	Arvbin[] vetor; /* Vetor com elementos */

    /* Constr�i heap vazio a partir dos elementos (caracteres). */
    public BinMinHeap(int tamanho) {
        n = tamanho;
        tam = tamanho;
        vetor = new Arvbin[tamanho+1];
    }

    /* Testa se a heap est� vazia. */
    public boolean vazia() {
        return n == 0;
    }

    /* Refaz a condi��o de heap (heapify). */
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
                vetor[i] = vetor[smallestChild];
            } else {
                break;
            }

            i = smallestChild;
        }

        vetor[i] = x;
    }

    /* Constr�i a heap (build heap). */
    public void constroiHeap() {
        for(int i = n / 2; i > 0; i--)
            refaz(i);
    }

    /* L� dados via teclado e insere na heap. */
    public void carregaDados() {
        int errors = 0;
        for (int i = 0; i < tam + errors; i++) {
            StringOut.printInputDialog(
                    "Digite o s�mbolo e a frequ�ncia" +
                            " (" + (i + 1 - errors) + "/" + tam + ")");
            String input = StringIn.getInstance().textInput();
            if (StringFormat.isValid(input, "^. \\d+$")) {
                vetor[i + 1 - errors] = new Arvbin(StringFormat.getChar(input), StringFormat.getInt(input));
            } else {
                StringOut.printError("Voc� digitou uma entrada inv�lida");
                errors++;
            }
        }
        constroiHeap();

        StringOut.printNewLine();
        StringOut.printSeparator();
    }

    /* Executa o algoritmo de Huffman. */
    public void aplicaHuffman() {
        int count = 1;

        StringOut.printSeparator();
        StringOut.printTitleBlock("Etapas do Algoritmo de Huffman:");

        while (n > 1) {
            Arvbin a1 = removeMin();
            Arvbin a2 = removeMin();

            Arvbin parent = new Arvbin(' ', a1.getFrequencia() + a2.getFrequencia(), a1, a2);

            insere(parent);

            StringOut.printTitleBlock("PASSO " + count);
            imprime();
            StringOut.printSeparator();
            count++;
        }
    }

    /* Chama o m�todo mostra c�digos da classe Arvbin. */
    public void mostraCodigos() {
        StringOut.printTitleBlock("Representa��o da �rvore em pr�-ordem:");
        vetor[1].mostra();

        StringOut.printNewLine(2);
        StringOut.printSeparator();
        StringOut.printTitleBlock("Dicion�rio:");
        StringOut.printBlock("S�mbolo\t|\tCodifica��o");
        vetor[1].mostraCodigo("");

        StringOut.printSeparator();
        vetor[1].encode();
    }

    /* Insere x na heap. */
    public void insere(Arvbin x) {
        if (tam == n) {
            StringOut.printError("A lista est� cheia");
            return;
        }

        n++;
        int pos = n;

        vetor[0] = x;

        while(x.compareTo(vetor[pos/2]) < 0) {
            vetor[pos] = vetor[ pos/2 ];
            pos /= 2;
        }

        vetor[pos] = x;
    }

    /* Remove e retorna o menor item. */
    public Arvbin removeMin() {
        Arvbin smallestElement;

        if(this.vazia()) {
            StringOut.printError("A lista est� vazia");
            return null;
        }

        smallestElement = vetor[1];
        vetor[1] = vetor[n];
        n--;
        refaz(1);

        return smallestElement;
    }

    /* Imprime o conte�do da heap. */
    public void imprime() {
//        TODO: Aprimorar a formata��o da �rvore

        StringOut.printBlock("Representa��o em camadas:");

        int s = (n / 2) * 8;
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
            s = s - 4 >= 0 ? s - 4 : 0;
            offset = StringFormat.repeat(" ", s);
            count++;
            StringOut.printNewLine(2);
        }

        StringOut.printBlock("Representa��o em lista:");
        StringOut.printBlock("(�ndice) [s�mbolo | frequ�ncia]");

        for(int i = 1; i <= n; i++) {
            StringOut.printBlock("(" + i + ") " + vetor[i].toString() + " ");
        }

        StringOut.printNewLine();
    }
}
