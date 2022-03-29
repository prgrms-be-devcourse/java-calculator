package com.programmers.project;

import com.programmers.project.repository.DataRepository;
import com.programmers.project.repository.VolatilityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Calculate {
    Calculator calculator = new Calculator();
    DataRepository repository = new VolatilityRepository();

    @Test
    void 후위연산() {
        Queue<String> result = calculator.priority("3 + 2 * 4");
        StringBuilder sb = new StringBuilder();

        for(String str : result){
            sb.append(str);
        }

        Assertions.assertEquals("324*+", sb.toString());
    }

    @Test
    void 사칙연산(){
        double num1 = 2;
        double num2 = 3;
        Assertions.assertEquals(num1 + num2, calculator.cal(num1,num2,"+"));
        Assertions.assertEquals(num1 - num2, calculator.cal(num1,num2,"-"));
        Assertions.assertEquals(num1 * num2, calculator.cal(num1,num2,"*"));
        Assertions.assertEquals(num1 / num2, calculator.cal(num1,num2,"/"));
    }

    @Test
    void 계산결과출력(){
        double result = calculator.calculate(calculator.priority("13 + 2 * 4"));

        Assertions.assertEquals(13+2*4, result);
    }

    @Test
    void 연산저장하기(){
        String str = "13 * 4 + 3";

        Assertions.assertFalse(repository.show().contains(str));
        repository.add("13 * 4 + 3");
        Assertions.assertTrue(repository.show().contains(str));

    }

    @Test
    void 연산조회하기(){
        String str = "13 * 4 + 3";

        repository.add(str);
        List<String> results = repository.show();

        

    }
}
