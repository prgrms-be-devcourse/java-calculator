import fakeModel.FakeCalculator;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class CalculatorTest extends TestCase {

    private final FakeCalculator cal=new FakeCalculator();

    @Test
    public void testChangeToPosix(){
        String[] userStr={"5","+","2","*","7"};
        cal.changeToPosix(userStr);
        Assert.assertEquals("527*+",cal.getPosixList());
    }

    @Test
    public void testChangeToPosix2(){
        String[] userStr={"5","*","8","+","4","/","2"};
        cal.changeToPosix(userStr);
        Assert.assertEquals("58*42/+",cal.getPosixList());
    }

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
