package me.kimihiqq;

import lombok.RequiredArgsConstructor;
import me.kimihiqq.io.Input;
import me.kimihiqq.io.Output;
import me.kimihiqq.model.History;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class Calculator implements Runnable {

    private final Input scanner;
    private final Output printer;
    private final History history;

    public void run() {

        while (true) {
            printer.println("1. 조회\n2. 계산\n");
            String selectPage = scanner.nextLine("선택 : ");

            switch (selectPage) {
                case "1" -> list();
                case "2" -> calculate();
                default -> printer.println("Invalid page!");
            }
        }
    }

    public void calculate() {
        String formula = scanner.nextLine();
        if (!Pretreatment.validateFormula(formula)) return;
        List<String> terms = Pretreatment.parseFormula(formula);

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

        printer.println(terms.get(0));
        StringBuffer sb = new StringBuffer();
        String result = sb.append(formula)
                .append(" = ")
                .append(terms.get(0))
                .toString();
        history.add(result);
    }

    public void list() {
        Map<Integer, String> allHistory = history.getAll();
        for (Map.Entry<Integer, String> entry : allHistory.entrySet()) {
            printer.println(entry.getValue());
        }
        printer.println();
    }
}
