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
        StringOut.printTitleBlock("1 - Codificar com dicionário");
        StringOut.printTitleBlock("2 - Codificar sem dicionário");
        StringOut.printTitleBlock("3 - Decodificar");

        input = StringIn.getInstance().getInput(
                "Digite o número de uma opção do menu",
                "^[1-3]$",
                "Você digitou uma opção inválida"
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
                "Digite a quantidade de símbolos",
                "^\\d+$",
                "Você digitou uma entrada inválida"
        );

        BinMinHeap heap = new BinMinHeap(Integer.parseInt(input));
        heap.carregaDados();
        StringOut.printTitleBlock("Heap binário gerado:");
        heap.imprime();

        Stopwatch stopwatch = new Stopwatch();
        heap.aplicaHuffman();
        stopwatch.stop("Tempo de execução do algoritmo de Huffman:");

        StringOut.printNewLine();
        StringOut.printSeparator();
        heap.mostraCodigos();

        returnToMenu();
    }

    private static void autoEncoding() {

        input = StringIn.getInstance().getInput(
                "Digite um texto para ser codificado",
                "^.+$",
                "Você digitou uma entrada inválida"
        );

        Stopwatch stopwatchA = new Stopwatch();

        BinMinHeap heap = new BinMinHeap(StringFormat.countUniqueCharacters(input), input);
        heap.carregaDados(input);
        StringOut.printTitleBlock("Heap binário gerado:");
        heap.imprime();

        Stopwatch stopwatchB = new Stopwatch();
        heap.aplicaHuffman();
        stopwatchB.stop("Tempo de execução do algoritmo de Huffman:");

        heap.mostraCodigos();

        stopwatchA.stop("Tempo de execução total:");

        returnToMenu();
    }

    private static void manualDecoding() {

        input = StringIn.getInstance().getInput(
                "Digite a quantidade de símbolos",
                "^\\d+$",
                "Você digitou uma entrada inválida"
        );

        BinMinHeap heap = new BinMinHeap(Integer.parseInt(input));
        heap.carregaDados();
        StringOut.printTitleBlock("Heap binário gerado:");
        heap.imprime();
        Stopwatch stopwatchB = new Stopwatch();
        heap.aplicaHuffman();
        stopwatchB.stop("Tempo de execução do algoritmo de Huffman:");

        input = StringIn.getInstance().getInput(
                "Digite um texto codificado com base no dicionário",
                "^.+$",
                "Você digitou uma entrada inválida"
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
                "Você digitou uma entrada inválida"
        );
        showMenu();
    }
}
