package com.bressio;

import java.util.Scanner;

public class LegacyMain
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.println("Quantos simbolos?");
        n = scanner.nextInt();

        BinMinHeap heap = new BinMinHeap(n);
        heap.carregaDados();
        heap.imprime();
        heap.aplicaHuffman();
        heap.mostraCodigos();

        scanner.close();
    }
}