package com.bressio;

import java.util.Scanner;

public class StringIn {

    private static final StringIn singleton = new StringIn();
    private Scanner scanner;

    private StringIn() {
        scanner = new Scanner(System.in);
    }

    public String textInput() {
        String input = scanner.nextLine();
        if (input.equals("exit")) {
            System.exit(0);
        }
        return input;
    }

    public static StringIn getInstance(){
        return singleton;
    }
}
