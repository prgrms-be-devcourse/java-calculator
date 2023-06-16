package me.kimihiqq;

import me.kimihiqq.io.Input;
import me.kimihiqq.io.Output;
import me.kimihiqq.model.History;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class CalculatorTest {

//    @Test
//    public void testCalculate() {
//        History history = new History();
//        Input mockInput = Mockito.mock(Input.class);
//        Output mockOutput = Mockito.mock(Output.class);
//
//        when(mockInput.nextLine()).thenReturn("1 + 2 * 3");
//
//        Calculator calculator = new Calculator(mockInput, mockOutput, history);
//        calculator.calculate();
//
//        verify(mockOutput).println("7");
//    }
//
//    @Test
//    public void testList() {
//        History history = new History();
//        Input mockInput = Mockito.mock(Input.class);
//        Output mockOutput = Mockito.mock(Output.class);
//
//        when(mockInput.nextLine()).thenReturn("5 + 6", "4 * 2");
//
//        Calculator calculator = new Calculator(mockInput, mockOutput, history);
//        calculator.calculate();
//        calculator.calculate();
//
//        calculator.list();
//
//        verify(mockOutput).println("5 + 6 = 11");
//        verify(mockOutput).println("4 * 2 = 8");
//    }
}