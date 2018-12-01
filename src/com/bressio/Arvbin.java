package com.bressio;

/* Nessa implementa��o, os conceitos de "n�" e "�rvore" se misturam. */
public class Arvbin implements Comparable<Arvbin>{
    private char simbolo; /* S�mbolo armazenado na raiz. */
    private int frequencia; /* Frequ�ncia do s�mbolo armazenado na raiz. */
    private Arvbin esq, dir; /* Refer�ncias para sub�rvores esquerda e direita. */

    /* Construtor de �rvore sem sub�rvores (dir = esq = null). S�o fornecidos
     * apenas o s�mbolo e a frequ�ncia da raiz. */
    public Arvbin(char simbolo, int frequencia) {
        this.simbolo = simbolo;
        this.frequencia = frequencia;
        esq = null;
        dir = null;
    }

    /* Construtor de �rvore com sub�rvores. Al�m de s�mbolo e frequ�ncia da raiz,
     * s�o fornecidas as sub�rvores, que devem ter sido constru�das previamente. */
    public Arvbin(char simbolo, int frequencia, Arvbin esq, Arvbin dir) {
        /* O grupo deve preencher a implementa��o */
    }

    /* Imprime o conte�do da �rvore em pr�-ordem. */
    public void mostra() {
        /* O grupo deve preencher a implementa��o */
    }

    /* Novo m�todo para imprimir os c�digos de Huffman de cada s�mbolo na �rvore. */
    public void mostraCodigo() {
        /* O grupo deve preencher a implementa��o */
    }

    @Override
    public int compareTo(Arvbin arvbin) {
        return Integer.compare(frequencia, arvbin.frequencia);
    }

    @Override
    public String toString() {
        return "[" + simbolo + " | " + frequencia + "]";
    }

    /* Caso necess�rio, o grupo pode definir novos m�todos. */
}