package com.bressio;

/* Nessa implementação, os conceitos de "nó" e "árvore" se misturam. */
public class Arvbin implements Comparable<Arvbin>{
    private char simbolo; /* Símbolo armazenado na raiz. */
    private int frequencia; /* Frequência do símbolo armazenado na raiz. */
    private Arvbin esq, dir; /* Referências para subárvores esquerda e direita. */

    /* Construtor de árvore sem subárvores (dir = esq = null). São fornecidos
     * apenas o símbolo e a frequência da raiz. */
    public Arvbin(char simbolo, int frequencia) {
        this.simbolo = simbolo;
        this.frequencia = frequencia;
        esq = null;
        dir = null;
    }

    /* Construtor de árvore com subárvores. Além de símbolo e frequência da raiz,
     * são fornecidas as subárvores, que devem ter sido construídas previamente. */
    public Arvbin(char simbolo, int frequencia, Arvbin esq, Arvbin dir) {
        this.simbolo = simbolo;
        this.frequencia = frequencia;
        this.esq = esq;
        this.dir = dir;
    }

    /* Imprime o conteúdo da árvore em pré-ordem. */
    public void mostra() {
        StringOut.printInline("( ");
        StringOut.printInline(String.valueOf(frequencia) + " " + simbolo);
        if (esq != null) {
            esq.mostra();
        }
        if (dir != null) {
            dir.mostra();
        }
        StringOut.printInline(" )");
    }

    /* Novo método para imprimir os códigos de Huffman de cada símbolo na árvore. */
    public void mostraCodigo(String codigo) {
        if (simbolo != ' ') {
            StringOut.printBlock(simbolo + "\t\t|\t\t" + codigo);
        } else {
            esq.mostraCodigo(codigo + 0);
            dir.mostraCodigo(codigo + 1);
        }
    }

    public int getFrequencia() {
        return frequencia;
    }

    @Override
    public int compareTo(Arvbin arvbin) {
        return Integer.compare(frequencia, arvbin.frequencia);
    }

    @Override
    public String toString() {
        return "[" + simbolo + " | " + frequencia + "]";
    }

    /* Caso necessário, o grupo pode definir novos métodos. */
}
