import com.programmers.java.engine.io.exception.ParsedException;
import com.programmers.java.engine.model.Calculator;
import fakeModel.FakeCalculator;
import fakeModel.FakeOperator;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

public class CalculatorTest extends TestCase {

    private final Calculator cal=new Calculator();

    @Test
    public void testCalculate(){
        String[] userStr={"5","+","2","*","7"};
        Assert.assertEquals("19",cal.calculate(userStr));
    }

    @Test
    public void testCalculate2(){
        String[] userStr={"5","*","8","+","4","/","2"};
        Assert.assertEquals("42",cal.calculate(userStr));
    }

}
