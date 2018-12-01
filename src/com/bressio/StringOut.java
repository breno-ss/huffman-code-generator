package com.bressio;

import static com.bressio.StringFormat.repeat;

public final class StringOut {

    private enum Color {
        RESET("\u001B[0m"), GREEN("\u001B[32m"), RED("\u001B[31m"), BLUE("\u001B[34m");

        Color(String color) {
            this.color = color;
        }
        private String color;

        public String getColor() {
            return color;
        }
    }

    private StringOut() {}

    public static void printInputDialog(String str) {
        System.out.print(Color.GREEN.getColor() +
                repeat("-", str.length()) + '\n' + str + '\n' +
                repeat("-", str.length()) +
                '\n' + ">>> ");
        resetColor();
    }

    public static void printError(String str) {
        System.out.println(Color.RED.getColor() +
                repeat("-", str.length() + 12) + '\n' + "[!]=[ " + str + " ]=[!]" + '\n' +
                repeat("-", str.length() + 12));
        resetColor();
    }

    public static void printColumn(String str) {
        System.out.println(Color.BLUE.getColor() + str);
        resetColor();
    }

    public static void printRow(String str) {
        System.out.print(Color.BLUE.getColor() + str);
        resetColor();
    }

    private static void resetColor() {
        System.out.print(Color.RESET.getColor());
    }
}
