package com.bressio;

public class Main {

    static String input;
    static boolean valid;

    public static void main(String args[]) {
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

        showMenu();
    }

    public static void showMenu() {
        valid = false;

        do {
            StringOut.printTitleBlock("M E N U");
            StringOut.printTitleBlock("1 - Codificar com frequ�ncia manual");
            StringOut.printTitleBlock("2 - Codificar com frequ�ncia autom�tica");
            StringOut.printInputDialog("Digite o n�mero de uma op��o do menu");

            input = StringIn.getInstance().textInput();

            if (!StringFormat.isValid(input, "^\\d$")) {
                StringOut.printError("Voc� digitou uma op��o inv�lida");
            } else {
                valid = true;
            }
        } while (!valid);

        switch (input) {
            case "1" : manualEncoding();
                break;
            case "2" : autoEncoding();
                break;
        }
    }

    private static void manualEncoding() {
        valid = false;

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

    private static void autoEncoding() {
        valid = false;

        do {
            StringOut.printInputDialog("Digite um texto para ser codificado");
            input = StringIn.getInstance().textInput();

            if (!StringFormat.isValid(input, "^.+$")) {
                StringOut.printError("Voc� digitou uma entrada inv�lida");
            } else {
                valid = true;
            }
        } while (!valid);

        BinMinHeap heap = new BinMinHeap(StringFormat.countUniqueCharacters(input), input);
        heap.carregaDados(input);
        StringOut.printTitleBlock("Heap bin�rio gerado:");
        heap.imprime();
        heap.aplicaHuffman();
        heap.mostraCodigos();
    }
}
