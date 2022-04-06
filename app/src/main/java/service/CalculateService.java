package service;

import repository.ResultRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateService {

    public double CalValue(String userInput) {

        String[] userInputSplit = userInput.split(" ");

        List<String> calList = new ArrayList<>();

        Double result;

        for (int i = 0; i < userInputSplit.length - 1; i += 2) {
            String first = userInputSplit[i];
            String operator = userInputSplit[i + 1];
            String second = userInputSplit[i + 2];

            if (operator.equals("+") || operator.equals("-")) {
                calList.add(first);
                calList.add(operator);
            } else if (operator.equals("*")) {
                userInputSplit[i + 2] = String.valueOf(Double.parseDouble(first) * Double.parseDouble(second));
            } else {
                if (second.equals("0")) throw new ArithmeticException("0으로 나눌 수 없습니다.");
                userInputSplit[i + 2] = String.valueOf(Double.parseDouble(first) / Double.parseDouble(second));
            }
        }

        calList.add(userInputSplit[userInputSplit.length - 1]);

        result = Double.parseDouble(calList.get(0));

        for (int i = 1; i < calList.size(); i += 2) {
            if (calList.get(i).equals("+")) {
                result += Double.valueOf(calList.get(i + 1));
            } else if (calList.get(i).equals("-")) {
                result -= Double.valueOf(calList.get(i + 1));
            }
        }


        return result;
    }
    public void showRecord() {
        for (Long key : ResultRepository.db.keySet()) {
            System.out.println(ResultRepository.db.get(key).getExpressionWithResult());
        }
    }
}
