package calculator.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StrategyMappingTest {

    private StrategyMapping strategyMapping;

    @Test
    void 더하기전략(){
        strategyMapping = new StrategyMapping();
        CalculatorStrategy plusStrategy = strategyMapping.getCalculatorStrategy("+");
        Assertions.assertInstanceOf(PlusStrategy.class,plusStrategy);
        double result = plusStrategy.calculate(-1,4);
        Assertions.assertEquals(3.0,result);
    }

    @Test
    void 빼기전략(){
        strategyMapping = new StrategyMapping();
        CalculatorStrategy minusStrategy = strategyMapping.getCalculatorStrategy("-");
        Assertions.assertInstanceOf(MinusStrategy.class,minusStrategy);
        double result = minusStrategy.calculate(-1,4);
        Assertions.assertEquals(-5.0,result);
    }

    @Test
    void 곱하기전략(){
        strategyMapping = new StrategyMapping();
        CalculatorStrategy multiplyStrategy = strategyMapping.getCalculatorStrategy("*");
        Assertions.assertInstanceOf(MultiplyStrategy.class,multiplyStrategy);
        double result = multiplyStrategy.calculate(-1,4);
        Assertions.assertEquals(-4.0,result);
    }

    @Test
    void 나누기전략(){
        strategyMapping = new StrategyMapping();
        CalculatorStrategy divideStrategy = strategyMapping.getCalculatorStrategy("/");
        Assertions.assertInstanceOf(DivideStrategy.class,divideStrategy);
        double result = divideStrategy.calculate(-1,4);
        Assertions.assertEquals(-0.25,result);
    }

    @Test
    void 예외(){
        strategyMapping = new StrategyMapping();
        CalculatorStrategy calculatorStrategy = strategyMapping.getCalculatorStrategy("%");
        Assertions.assertNull(calculatorStrategy);
        Assertions.assertInstanceOf(CalculatorStrategy.class,calculatorStrategy);

    }
}