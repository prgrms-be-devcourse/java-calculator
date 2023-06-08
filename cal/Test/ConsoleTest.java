import junit.framework.Assert;
import model.Calculator;
import model.History;
import model.Operator;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsoleTest {
    Calculator cal = new Calculator();
    Operator operator = new Operator();
    History history = new History();

    Console console = new Console();
    @Test
    public void getHistory() {
        Boolean length =  history.isEmpty();
        assertEquals(Boolean.TRUE,length);

    }

    @Test
    public void input() {
        int result;

        result = cal.cal("1 + 3",operator, history);
        assertEquals(4,result);

        result = cal.cal("1 * 3 + 6",operator, history);
        assertEquals(9,result);

        int length =  history.getHistoryLen();
        assertEquals(2,length);
    }
}