import com.programmers.java.engine.model.Calculator;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class CalculatorTest extends TestCase {

    private Calculator cal=new Calculator();

    //private 메소드를 테스트할 때는 test할 때만 잠깐 public으로 해뒀다가 다시 돌리는게 맞나요?

/*
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
*/
    @Test
    public void testCalculate() throws Exception{
        String[] userStr={"5","+","2","*","7"};
        Assert.assertEquals("19",cal.calculate(userStr));
    }

    @Test
    public void testCalculate2() throws Exception{
        String[] userStr={"5","*","8","+","4","/","2"};
        Assert.assertEquals("42",cal.calculate(userStr));
    }

}
