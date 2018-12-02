package com.bressio;

public class Main {

    public static void main(String args[]) {
       String input;
        boolean valid = false;

        StringOut.printNewLine();
        StringOut.printInline("+-------------------------------------------+");
        StringOut.printNewLine();
        StringOut.printBlock("|   A L G O R I T M O  D E  H U F F M A N   |");
        StringOut.printBlock("| Criado por @bressio e @CarlosVasconcellos |");
        StringOut.printBlock("|            UNIRIO - EDI 2018.2            |");
        StringOut.printInline("+-------------------------------------------+");
        StringOut.printNewLine();
        StringOut.printBlock("A qualquer momento, digite \"exit\" para sair");
        StringOut.printNewLine();
        StringOut.printSeparator();

        do {
            StringOut.printInputDialog("Digite a quantidade de s�mbolos");
            input = StringIn.getInstance().textInput();

            if (!StringFormat.isValid(input, "^\\d+$")) {
                StringOut.printError("Voc� digitou uma entrada inv�lida");
            } else {
                valid = true;
            }
        } while (!valid);

            BinMinHeap heap = new BinMinHeap(Integer.parseInt(input));
            heap.carregaDados();
            StringOut.printTitleBlock("Heap bin�rio gerado:");
            heap.imprime();
            heap.aplicaHuffman();
            heap.mostraCodigos();
    }
}
