import com.programmers.java.engine.model.Calculator;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class CalculatorTest extends TestCase {

    private Calculator cal=new Calculator();

    @Test
    public void testChangeToPosix() throws Exception{
        String[] userStr={"5","+","2","*","7"};
        cal.changeToPosix(userStr);
        Assert.assertEquals("527*+",cal.getPosixList());
    }

    @Test
    public void testChangeToPosix2() throws Exception{
        String[] userStr={"5","*","8","+","4","/","2"};
        cal.changeToPosix(userStr);
        Assert.assertEquals("58*42/+",cal.getPosixList());
    }
}
