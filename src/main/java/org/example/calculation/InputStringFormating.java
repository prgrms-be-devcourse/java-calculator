package org.example.calculation;

public class InputStringFormating{
    public static String[] formating(String input) {
        input = input.replace("+", " + ");
        input = input.replace("-", " - ");
        input = input.replace("/", " / ");
        input = input.replace("*", " * ");
        input = input.replace("  ", " ");

        String[] str = input.split(" ");
        return str;
    }
}
