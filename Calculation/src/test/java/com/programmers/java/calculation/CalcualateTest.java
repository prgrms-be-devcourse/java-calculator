package com.programmers.java.calculation;

import com.programmers.java.calculation.calculate.Calculate;
import com.programmers.java.calculation.calculate.CalculateBasicImpl;
import com.programmers.java.calculation.parse.ParsingImpl;
import com.programmers.java.calculation.parse.ValidationImpl;
import com.programmers.java.calculation.parse.Validation;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalcualateTest {

    ParsingImpl parsing = new ParsingImpl();
    Validation validation = new ValidationImpl();
    Calculate calculate = new CalculateBasicImpl();


    @Test
    public void version1() throws Exception {
        String input = "12-2";
        calcalateTotal(input);

        String input2 = "11-3";
        calcalateTotal(input2);

        String inputSpace = "1-5";
        calcalateTotal(inputSpace);

        String inputFirstMul = "*1+2/3*4+5-6*4";
        calcalateTotal(inputFirstMul);

        String inputFirstDiv = "/1+2/3*4+5-6*4";
        calcalateTotal(inputFirstDiv);


        String inputContOp = "1+/2/3*4+5-6*4";
        calcalateTotal(inputContOp);


    }

    private void calcalateTotal(String input) {
        String result1 = parsing.removeSpase(input);
        boolean validateString = validation.validateString(result1);
        boolean validateContOp = validation.validateContOp(result1);
        boolean validateFirstOp = validation.validateFirstOp(result1);
        boolean validateLastOp = validation.validateLastOp(result1);

        if (validateTotal(validateString, validateContOp, validateFirstOp, validateLastOp)) {
            List<String> resultList = parsing.makeArray(result1);
            Double cal = calculate.cal(resultList);
            System.out.println("cal = " + cal);
        } else {
            System.out.println("뭔가가 잘못되었습니다?");
        }
    }


    private boolean validateTotal(boolean validateString, boolean validateContOp, boolean validateFirstOp, boolean validateLastOp) {
        return validateString && validateContOp && validateFirstOp && validateLastOp;
    }
}
