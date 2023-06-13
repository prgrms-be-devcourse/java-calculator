package org.calculator.engine;


import org.calculator.engine.domain.History;
import org.calculator.repository.CalculateRepository;
import org.calculator.repository.CalculateRepositoryImpl;

import java.util.ArrayList;

public class CalculateEngine {
    private String num = "";
    private ArrayList<String> equation = new ArrayList <>();
    private final CalculateRepository calculateRepository = new CalculateRepositoryImpl();
    public double calculate(String inputText) {
        num = "";
        fullTextParsing(inputText);
        double prev = 0;
        double current = 0;
        String mode = "";

        for (int i = 0; i < equation.size(); i++) {
            String s = equation.get(i);

            if ("+".equals(s)) {
                mode = "add";
            } else if ("-".equals(s)) {
                mode = "sub";
            } else if ("*".equals(s)) {
                mode = "mul";
            } else if ("/".equals(s)) {
                mode = "div";
            } else {
                if (("mul".equals(mode) || "div".equals(mode)) && !"+".equals(s) && !"-".equals(s) && !"*".equals(s) && !"/".equals(s)) {
                    Double one = Double.parseDouble(equation.get(i - 2));
                    Double two = Double.parseDouble(equation.get(i));
                    Double result = 0.0;

                    if ("mul".equals(mode)) {
                        result = one * two;
                    } else if ("div".equals(mode)) {
                        result = one / two;
                    }

                    equation.add(i + 1, Double.toString(result));

                    for (int j = 0; j < 3; j++) {
                        equation.remove(i - 2);
                    }

                    i -= 2;    // 결과값이 생긴 인덱스로 이동
                }
            }
        }	// 곱셈 나눗셈을 먼저 계산한다

        mode = "";
        for (String s : equation) {
            if ("+".equals(s)) {
                mode = "add";
            } else if ("-".equals(s)) {
                mode = "sub";
            }  else {
                current = Double.parseDouble(s);
                if ("add".equals(mode)) {
                    prev += current;
                } else if ("sub".equals(mode)) {
                    prev -= current;
                } else {
                    prev = current;
                }
            }
            prev = Math.round(prev * 100000) / 100000.0;
        }
        calculateRepository.save(new History(inputText, prev));
        return prev;

    }

    private void fullTextParsing(String inputText) {
        equation.clear();
        for (int i = 0; i < inputText.length(); i++) {
            char ch = inputText.charAt(i);

            if (ch == '-' || ch == '+' || ch == '*' || ch == '/') {
                equation.add(num);
                num = "";
                equation.add(ch + "");
            } else {
                num = num + ch;
            }
        }
        equation.add(num);
        equation.remove("");
    }
}
