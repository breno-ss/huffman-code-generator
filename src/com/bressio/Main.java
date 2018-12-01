package com.bressio;

public class Main {

    public static void main(String args[]) {
       String input;
        boolean valid = false;

        StringOut.printBlock("Algoritmo de Huffman");
        StringOut.printBlock("A qualquer momento, digite \"exit\" para sair");
        StringOut.printNewLine();

        do {
            StringOut.printInputDialog("Digite a quantidade de s�mbolos");
            input = StringIn.getInstance().textInput();

            if (!StringFormat.isValid(input, "^\\d*$")) {
                StringOut.printError("Voc� digitou uma entrada inv�lida");
            } else {
                valid = true;
            }
        } while (!valid);

            BinMinHeap heap = new BinMinHeap(Integer.parseInt(input));
            heap.carregaDados();
            heap.imprime();
            heap.aplicaHuffman();
            heap.mostraCodigos();
    }
}
