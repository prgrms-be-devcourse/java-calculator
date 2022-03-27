package caculator;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
public class Calculator {
    public static boolean isFormula(StringBuilder formula) {
        String formulaPattern = "^-?\\d+([\\+\\-\\*\\/]\\d+)*$";
        return Pattern.matches(formulaPattern, formula.toString());
    }

    public static float calculate(StringBuilder formula) {
        ArrayList<String> tks = tokenParse(formula.toString());
        ArrayList<Float> list = new ArrayList<>();
        int idx = 0;
        Float current = Float.parseFloat(tks.get(idx++));
        String operator = null;
        try{
            while(idx < tks.size()) {
                operator = tks.get(idx++);
                switch (operator) {
                    case "+" -> {
                        list.add(current);
                        current = Float.parseFloat(tks.get(idx++));
                    }
                    case "-" -> {
                        list.add(current);
                        current = - Float.parseFloat(tks.get(idx++));
                    }
                    case "*" -> {
                        current *= Float.parseFloat(tks.get(idx++));
                    }
                    case "/" -> {
                        current /= Float.parseFloat(tks.get(idx++));
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        list.add(current);
        float result = 0;
        for(int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        return result;
    }

    private static ArrayList<String> tokenParse(String formula) {
        ArrayList<String> tks = new ArrayList<>();
        Pattern pattern1 = Pattern.compile("^-?\\d+");
        Matcher matcher1 = pattern1.matcher(formula);
        int idx = 0;

        //first element
        while(matcher1.find()) {
            tks.add(matcher1.group());
            idx = matcher1.end();
        }
        //second element(optional)
        Pattern pattern2 = Pattern.compile("[\\+\\-\\*\\/]\\d+");
        Matcher matcher2 = pattern2.matcher(formula.toString().substring(idx));
        while(matcher2.find()) {
            String tk = matcher2.group();
            tks.add(tk.substring(0,1));
            tks.add(tk.substring(1));
        }
        return tks;
    }

    public static void print(ArrayList<String> st) {
        Optional<ArrayList<String>> tmp = Optional.ofNullable(st);
        tmp.ifPresent((value)->{value.forEach(System.out::println);});
    }
}
