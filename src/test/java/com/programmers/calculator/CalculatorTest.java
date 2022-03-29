package com.programmers.calculator;

import com.programmers.calculator.repository.MemoryRepository;
import com.programmers.calculator.util.io.Console;
import org.junit.jupiter.api.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("계산기 내부 로직 테스트")
public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        Console console = new Console();
        calculator = new Calculator(console, console, new MemoryRepository());
    }

    @DisplayName("calculate() 테스트")
    @Nested
    class CalculateTest {
        @DisplayName("후위 표기식으로 변경이 완료된 경우 계산 성공 사례")
        @Test
        void CalculateSuccess() {
            List<DataForCalculator> list = new ArrayList<>();
            list.add(new DataForCalculator(new String[]{"1", "2", "+"}, "3.0"));
            list.add(new DataForCalculator(new String[]{"1", "2", "3", "*", "-"}, "-5.0"));
            list.add(new DataForCalculator(new String[]{"1", "2", "3", "*", "+"}, "7.0"));
            list.add(new DataForCalculator(new String[]{"3", "2", "2", "*", "-"}, "-1.0"));

            try {
                Method method = calculator.getClass().getDeclaredMethod("calculate", String[].class);
                method.setAccessible(true);
                list.forEach(dataForCalculator -> {
                    try {
                        assertEquals(dataForCalculator.getResult(), method.invoke(calculator, (Object) dataForCalculator.getOrigin()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    static class DataForCalculator {
        private final String[] origin;
        private final String result;

        DataForCalculator(String[] origin, String result) {
            this.origin = origin;
            this.result = result;
        }

        public String[] getOrigin() {
            return origin;
        }

        public String getResult() {
            return result;
        }
    }
}
