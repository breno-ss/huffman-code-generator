package com.bressio;

import java.util.Scanner;

public class StringIn {

    private static final StringIn singleton = new StringIn();
    private Scanner scanner;

    private StringIn() {
        scanner = new Scanner(System.in);
    }

    public String textInput() {
        return scanner.nextLine();
    }

    public static StringIn getInstance(){
        return singleton;
    }
}
