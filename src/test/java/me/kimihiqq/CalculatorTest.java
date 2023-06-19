package me.kimihiqq;

import me.kimihiqq.io.Input;
import me.kimihiqq.io.Output;
import me.kimihiqq.model.History;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CalculatorTest {

    @DisplayName("계산기 정상 계산 테스트")
    @Test
    public void testCalculate() {
        History history = new History();
        Input mockInput = Mockito.mock(Input.class);
        Output mockOutput = Mockito.mock(Output.class);

        when(mockInput.nextLine()).thenReturn("-1 + 2 * 3");

        Calculator calculator = new Calculator(mockInput, mockOutput, history);
        calculator.calculate();

        String expectedHistory = "-1 + 2 * 3 = 5";
        Map<Integer, String> allHistory = history.getAll();
        assertTrue(allHistory.containsValue(expectedHistory));
    }

    @DisplayName("계산기 이력 조회 테스트")
    @Test
    public void testList() {
        History history = new History();
        Input mockInput = Mockito.mock(Input.class);
        Output mockOutput = Mockito.mock(Output.class);

        when(mockInput.nextLine()).thenReturn("5 + 6", "4 * 2");

        Calculator calculator = new Calculator(mockInput, mockOutput, history);
        calculator.calculate();
        calculator.calculate();

        calculator.list();

        Map<Integer, String> allHistory = history.getAll();
        String expectedHistory1 = "5 + 6 = 11";
        String expectedHistory2 = "4 * 2 = 8";
        assertTrue(allHistory.containsValue(expectedHistory1));
        assertTrue(allHistory.containsValue(expectedHistory2));
    }
}