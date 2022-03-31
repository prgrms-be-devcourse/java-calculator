import com.programmers.java.engine.io.exception.ParsedException;
import fakeModel.FakeCalculator;
import fakeModel.FakeOperator;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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

    @Test
    public void emptyParsingTest(){
        try {
            String emptyStr = "";
            Optional<String[]> parsedStr = fakeParse(emptyStr);
            Assert.assertEquals(Optional.empty(), parsedStr);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void parsingTest() throws Exception{
        try {
            String userStr = "1 * 2 + 8 / 2";
            Optional<String[]> parsedStr = fakeParse(userStr);
            StringBuilder actual= new StringBuilder();
            for(String str : parsedStr.get()){
                actual.append(str);
            }
            Assert.assertEquals("1*2+8/2", actual.toString());
        }catch(Exception e){
            throw(e);
        }
    }

    public Optional<String[]> fakeParse(String userStr) throws Exception{
        if(userStr.length()%2==0){
            System.out.println("length error");
            throw new ParsedException();
        }

        String[] parsedStr= userStr.split(" ");
        for(String str : parsedStr){
            try {
                Optional<FakeOperator> arg = FakeOperator.getOperator(str);
                if (arg.isEmpty()) {
                    Double.parseDouble(str);
                }
            } catch(NumberFormatException nfe){
                System.out.println("number format exception");
                throw new ParsedException();
            }
        }
        return Optional.of(parsedStr);
    }

}
