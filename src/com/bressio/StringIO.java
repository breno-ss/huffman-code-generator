package com.bressio;

import java.util.Scanner;

public class StringIO {

    private static final StringIO singleton = new StringIO();
    private static Scanner scanner;

    private StringIO() {
        scanner = new Scanner(System.in);
    }

    public String textInput() {
        return scanner.nextLine();
    }

    public static StringIO getInstance(){
        return singleton;
    }
}