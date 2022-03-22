package com.programmers.java.calculation.calculate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class CalculateImpl implements Calculate {

    @Override
    public Double cal(List<String> input) {
        List<String> operatorMulAndDiv = new ArrayList<>(Arrays.asList("*", "/"));
        List<String> operatorPlusAndMinus = new ArrayList<>(Arrays.asList("+", "-"));
        List<Double> nums = new ArrayList<>();
        int temp = 1;

        for (int i = 0; i < input.size(); i++) {
            if (operatorPlusAndMinus.contains(input.get(i))) {
                if (input.get(i) == "-") {
                    temp = -1;
                } else {
                    temp = 1;
                }
            } else if (operatorMulAndDiv.contains(input.get(i))) {
                int lastIndex = nums.size() - 1;
                Double mulDivResult;
                if (input.get(i) == "*") {
                    mulDivResult = nums.get(lastIndex) * Double.valueOf(input.get(i+1));
                } else {
                    if (Integer.valueOf(input.get(i+1)) == 0) {
                        return null;
                    }
                    mulDivResult = nums.get(lastIndex) / Double.valueOf(input.get(i+1));
                }
                nums.set(lastIndex, mulDivResult);
                i++;
            } else {
                Double result = temp * Double.valueOf(input.get(i));
                nums.add(result);
            }
        }

        Double result = Double.valueOf(0);
        for (int i = 0; i < nums.size(); i++) {
            result += nums.get(i);
        }
        return result;
    }
}
