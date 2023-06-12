import model.Calculator;
import model.History;
import model.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {

    Calculator cal = new Calculator();
    Operator operator = new Operator();
    History history = new History();

    @Test
    public void input() {
        Boolean len =  history.isEmpty();
        assertEquals(Boolean.TRUE,len);

        int result;

        result = cal.cal("1 + 3");
        assertEquals(4,result);

        result = cal.cal("1 * 3 + 6");
        assertEquals(9,result);

        int length =  history.getHistoryLen();
        assertEquals(2,length);
    }
}
