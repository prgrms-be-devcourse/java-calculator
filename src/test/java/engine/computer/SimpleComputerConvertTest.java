package engine.computer;

import com.devcourse.engine.computer.SimpleComputer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SimpleComputerConvertTest {

    @Test
    void convertTest1() {
        SimpleComputer simpleComputer = new SimpleComputer();
        List<String> result = simpleComputer.validate("1+1");
        Assertions.assertEquals(result.size(), simpleComputer.convert(result).size());
    }

    @Test
    void convertTest2() {
        SimpleComputer simpleComputer = new SimpleComputer();
        List<String> result = simpleComputer.validate("1 + 2* 5 - 8/4");
        Assertions.assertEquals(result.size(), simpleComputer.convert(result).size());
    }

    @Test
    void convertTest3() {
        SimpleComputer simpleComputer = new SimpleComputer();
        List<String> result = simpleComputer.validate("1+2*(10-8)/4");
        Assertions.assertEquals(result.size()-2, simpleComputer.convert(result).size());
    }

    @Test
    void convertTest4() {
        SimpleComputer simpleComputer = new SimpleComputer();
        List<String> result = simpleComputer.validate("(1+2*(10-8))/4");
        Assertions.assertEquals("12108-*+4/", String.join("", simpleComputer.convert(result)));
    }

}
