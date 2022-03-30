package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateService {

    public double CalValue(String userInput) {

        String[] userInputSplit = userInput.split(" ");

        List<String> plus = new ArrayList<>();
        List<String> minus = new ArrayList<>();

        Double result;

        for (int i = 0; i < userInputSplit.length - 1; i += 2) {
            String first = userInputSplit[i];
            String operator = userInputSplit[i + 1];
            String second = userInputSplit[i + 2];

            if (operator.equals("+")) {
                plus.add(first);
            } else if (operator.equals("-")) {
                minus.add(second);
            } else if (operator.equals("*")) {
                userInputSplit[i + 2] = String.valueOf(Double.parseDouble(first) * Double.parseDouble(second));
            } else {
                userInputSplit[i + 2] = String.valueOf(Double.parseDouble(first) / Double.parseDouble(second));
            }
        }

        result = Double.parseDouble(userInputSplit[userInputSplit.length - 1]);


        // 더하기 연산 마무리
        for (String number : plus) {
            result += Double.parseDouble(number);
        }

        // 빼기 연산 마무리
        for (String number : minus) {
            result -= Double.parseDouble(number);
        }

        return result;
    }
}
