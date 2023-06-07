package model;

import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
    public Integer cal(String inputString, Operator operator,History history) {
        StringBuilder sb = new StringBuilder();

        int result = operator.operate(inputString);

         history.addHistory(sb.append(inputString).append(" = ").append(result).toString());

         return result;
    }


}
