package calculator.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    Validation validation = new ValidationImpl();
    @Test
    void 연산자인지확인(){
        ArrayList<String> operatorList = new ArrayList<String>();
        operatorList.add("+");
        operatorList.add("-");
        operatorList.add("*");
        operatorList.add("/");
        operatorList.forEach(s -> assertTrue(validation.isOperator(s)));

        assertFalse(validation.isOperator("%"));
    }

    @Test
    void 나누기예외(){
        assertFalse(validation.divideByZero("/", 0));
        assertTrue(validation.divideByZero("*", 0));
        assertTrue(validation.divideByZero("/", 10));
        assertTrue(validation.divideByZero("*", 10));
    }

}