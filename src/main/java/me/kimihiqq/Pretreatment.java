package me.kimihiqq;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pretreatment {

    public static List<String> parseFormula(String formula) {
        String[] arr = formula.split(" ");
        return Arrays.stream(arr).collect(Collectors.toList());
    }

    public static boolean validateFormula(String formula) {
        if (!formula.matches("^(-*\\d+\\s[+\\-*/]\\s)+\\d+$")) {
            System.out.println("Invalid formula!");
            return false;
        }
        return true;
    }
}
