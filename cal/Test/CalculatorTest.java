import model.Calculator;
import model.History;
import model.Operator;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class CalculatorTest {


    @BeforeEach
    public void setUp(){

    }

    @Test
    public void input() {
        Calculator cal = new Calculator();
        Operator operator = new Operator();
        History history = new History();
        int result;
        result = cal.cal("1 + 3",operator, history);
        assertEquals(4,result);

        result = cal.cal("1 * 3 + 6",operator, history);
        assertEquals(9,result);

        result = cal.cal("7 * 18 / 9",operator, history);
        assertEquals(14,result);

        result = cal.cal("1 + 3 * 9 - 7 * 8 * 2 / 8",operator, history);
        assertEquals(14,result);

        result = cal.cal("100 / 4 / 25",operator, history);
        assertEquals(1,result);

    }
}