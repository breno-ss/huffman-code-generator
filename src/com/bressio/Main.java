package com.bressio;

public class Main {

    private static String input;

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

        StringOut.printTitleBlock("M E N U");
        StringOut.printTitleBlock("1 - Codificar com dicion�rio");
        StringOut.printTitleBlock("2 - Codificar sem dicion�rio");
        StringOut.printTitleBlock("3 - Decodificar");

        input = StringIn.getInstance().getInput(
                "Digite o n�mero de uma op��o do menu",
                "^[1-3]$",
                "Voc� digitou uma op��o inv�lida"
        );

        switch (input) {
            case "1" : manualEncoding();
                break;
            case "2" : autoEncoding();
                break;
            case "3" : manualDecoding();
                break;
        }
    }

    private static void manualEncoding() {

        input = StringIn.getInstance().getInput(
                "Digite a quantidade de s�mbolos",
                "^\\d+$",
                "Voc� digitou uma entrada inv�lida"
        );

        BinMinHeap heap = new BinMinHeap(Integer.parseInt(input));
        heap.carregaDados();
        StringOut.printTitleBlock("Heap bin�rio gerado:");
        heap.imprime();

        Stopwatch stopwatch = new Stopwatch();
        heap.aplicaHuffman();
        stopwatch.stop("Tempo de execu��o do algoritmo de Huffman:");

        StringOut.printNewLine();
        StringOut.printSeparator();
        heap.mostraCodigos();

        returnToMenu();
    }

    private static void autoEncoding() {

        input = StringIn.getInstance().getInput(
                "Digite um texto para ser codificado",
                "^.+$",
                "Voc� digitou uma entrada inv�lida"
        );

        Stopwatch stopwatchA = new Stopwatch();

        BinMinHeap heap = new BinMinHeap(StringFormat.countUniqueCharacters(input), input);
        heap.carregaDados(input);
        StringOut.printTitleBlock("Heap bin�rio gerado:");
        heap.imprime();

        Stopwatch stopwatchB = new Stopwatch();
        heap.aplicaHuffman();
        stopwatchB.stop("Tempo de execu��o do algoritmo de Huffman:");

        heap.mostraCodigos();

        stopwatchA.stop("Tempo de execu��o total:");

        returnToMenu();
    }

    private static void manualDecoding() {

        input = StringIn.getInstance().getInput(
                "Digite a quantidade de s�mbolos",
                "^\\d+$",
                "Voc� digitou uma entrada inv�lida"
        );

        BinMinHeap heap = new BinMinHeap(Integer.parseInt(input));
        heap.carregaDados();
        StringOut.printTitleBlock("Heap bin�rio gerado:");
        heap.imprime();
        Stopwatch stopwatchB = new Stopwatch();
        heap.aplicaHuffman();
        stopwatchB.stop("Tempo de execu��o do algoritmo de Huffman:");

        input = StringIn.getInstance().getInput(
                "Digite um texto codificado com base no dicion�rio",
                "^.+$",
                "Voc� digitou uma entrada inv�lida"
        );

        heap.decode(input);

        returnToMenu();
    }

    private static void returnToMenu() {
        StringOut.printNewLine();
        StringOut.printSeparator();
        input = StringIn.getInstance().getInput(
                "Digite menu para voltar ou exit para sair",
                "^.+$",
                "Voc� digitou uma entrada inv�lida"
        );
        showMenu();
    }
}
