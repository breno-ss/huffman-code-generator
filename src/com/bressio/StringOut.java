package com.bressio;

import static com.bressio.StringFormat.repeat;

public final class StringOut {

    private StringOut() {}

    public static void printInputDialog(String str) {
        System.out.println(repeat("-", str.length()) + '\n' + str + '\n' + repeat("-", str.length()));
    }

    public static void printError(String str) {
        System.out.println(repeat("-", str.length()) + '\n' + str + '\n' + repeat("-", str.length()));
    }

    public static void printColumn(String str) {
        System.out.println(str);
    }
}
