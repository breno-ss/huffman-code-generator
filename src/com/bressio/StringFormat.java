package com.bressio;

import java.util.Collections;

public final class StringFormat {

    private StringFormat() {}

    public static boolean isValid(String str) {
        return str.matches("^. \\d*$");
    }

    public static char getChar(String str) {
        return str.charAt(0);
    }

    public static int getInt(String str) {
        return Integer.parseInt(str.split(" ")[1]);
    }

    public static String repeat(String str, int n) {
        return String.join("", Collections.nCopies(n, str));
    }
}
