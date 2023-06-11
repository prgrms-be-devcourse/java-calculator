package me.kimihiqq;

import java.util.*;
import java.util.stream.Collectors;

public class Application {

    private Scanner scanner = new Scanner(System.in);
    private Map<Integer, String> history = new HashMap<>();
    private int id = 0;

    public void menu() {
        while (true) {
            System.out.println("1. 조회");
            System.out.println("2. 계산");
            System.out.println();
            System.out.print("선택 : ");
            String selectPage = scanner.nextLine();

            switch (selectPage) {
                case "1" -> list();
                case "2" -> calculate();
            }
        }
    }

    public void calculate() {
        String formula = scanner.nextLine();

        if (!formula.matches("^(\\d\\s[+\\-*/]\\s)+\\d$")) {
            System.out.println("Invalid formula!");
            return;
        }

        String[] arr = formula.split(" ");
        List<String> terms = Arrays.stream(arr).collect(Collectors.toList());

        int i = 0;
        while (i < terms.size()) {
            if (terms.get(i).equals("*") || terms.get(i).equals("/")) {
                long leftHandSide = Long.parseLong(terms.get(i - 1));
                long rightHandSide = Long.parseLong(terms.get(i + 1));
                long result = 0;
                if (terms.get(i).equals("*")) {
                    result = leftHandSide * rightHandSide;
                } else if (terms.get(i).equals("/")) {
                    result = leftHandSide / rightHandSide;
                }
                for (int j = 0; j < 3; j++) {
                    terms.remove(i - 1);
                }
                terms.add(i - 1, String.valueOf(result));
            } else {
                i++;
            }
        }

        i = 0;
        while (i < terms.size()) {
            if (terms.get(i).equals("+") || terms.get(i).equals("-")) {
                long leftHandSide = Long.parseLong(terms.get(i - 1));
                long rightHandSide = Long.parseLong(terms.get(i + 1));
                long result = 0;
                if (terms.get(i).equals("+")) {
                    result = leftHandSide + rightHandSide;
                } else if (terms.get(i).equals("-")) {
                    result = leftHandSide - rightHandSide;
                }
                for (int j = 0; j < 3; j++) {
                    terms.remove(i - 1);
                }
                terms.add(i - 1, String.valueOf(result));
            } else {
                i++;
            }
        }

        System.out.println(terms.get(0));
        StringBuffer sb = new StringBuffer();
        String result = sb.append(formula)
                .append(" = ")
                .append(terms.get(0))
                .toString();
        storeHistory(result);
        System.out.println();
    }

    private void storeHistory(String result) {
        history.put(id++, result);
    }

    public void list() {
        for (Map.Entry<Integer, String> entry : history.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.menu();
    }
}
