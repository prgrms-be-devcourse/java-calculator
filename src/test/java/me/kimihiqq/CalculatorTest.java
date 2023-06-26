package me.kimihiqq;

import me.kimihiqq.io.Input;
import me.kimihiqq.io.Output;
import me.kimihiqq.model.History;
import me.kimihiqq.options.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.mockito.Mockito.*;

public class CalculatorTest {
    private Input mockInput;
    private Output mockOutput;
    private History mockHistory;
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        mockInput = Mockito.mock(Input.class);
        mockOutput = Mockito.mock(Output.class);
        mockHistory = Mockito.mock(History.class);
        calculator = new Calculator(mockInput, mockOutput, mockHistory);
    }

    @Test
    public void testCalculationFlow() {
        // Arrange
        when(mockInput.nextLine("선택 : ")).thenReturn(Option.CALCULATE.getValue(), Option.CALCULATE.getValue(), Option.EXIT.getValue());
        when(mockInput.nextLine()).thenReturn("-1 + 34.3 / 3 * 5.2", "13.3 - 2.5 * 5.9 / 1.1");

        // Act
        calculator.run();

        // Assert
        verify(mockOutput, times(1)).printResult("58.453333333333326");
        verify(mockHistory, times(1)).add("-1 + 34.3 / 3 * 5.2 = 58.453333333333326");

        calculator.run();

        verify(mockOutput, times(1)).printResult("-0.10909090909090757");
        verify(mockHistory, times(1)).add("13.3 - 2.5 * 5.9 / 1.1 = -0.10909090909090757");
    }
}