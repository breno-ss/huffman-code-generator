package com.bressio;

import java.util.Map;
import java.util.TreeMap;

/* Nessa implementação, os conceitos de "nó" e "árvore" se misturam. */
public class Arvbin implements Comparable<Arvbin>{
    private char simbolo; /* Símbolo armazenado na raiz. */
    private int frequencia; /* Frequência do símbolo armazenado na raiz. */
    private Arvbin esq, dir; /* Referências para subárvores esquerda e direita. */
    private static Map<Character, String> dictionary = new TreeMap<>();

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
        if (simbolo != '\t') {
            StringOut.printBlock(simbolo + "\t\t|\t\t" + codigo);
            dictionary.put(simbolo, codigo);
        } else {
            esq.mostraCodigo(codigo + 0);
            dir.mostraCodigo(codigo + 1);
        }
    }

    public void encode() {
        String input;
        boolean undefined;
        int size = 0;

        do {
            StringOut.printInputDialog("Digite um texto");
            input = StringIn.getInstance().textInput();

            undefined = false;

            for (char c : input.toCharArray()) {
                if (!dictionary.containsKey(c)) {
                    StringOut.printError("O texto contém caracteres fora do dicionário");
                    undefined = true;
                    break;
                }
            }
        } while (undefined);

        StringOut.printNewLine();
        StringOut.printSeparator();
        StringOut.printTitleBlock("Texto codificado:");
        StringOut.printNewLine();

        for (char c : input.toCharArray()) {
            String code = dictionary.get(c);
            StringOut.printInline(code);
            size += code.length();
        }

        StringOut.printNewLine();

        int original = (int) Math.ceil(((8.0 * input.length()) / 8.0));
        int compressed = (int) Math.ceil((size / 8.0));

        StringOut.printBlock("Tamanho original: " + original + (original >= 2 ? " bytes" : " byte"));
        StringOut.printBlock("Tamanho comprimido: " + compressed + (compressed >= 2 ? " bytes" : " byte"));
        StringOut.printBlock("Redução: " + (int) (((float) compressed / original) * 100) + "%");
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
