package engine.computer;

import com.devcourse.engine.computer.Computer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComputerConvertTest {

    @Test
    void convertTest1() {
        Computer computer = new Computer();
        List<String> result = computer.validate("1+1");
        Assertions.assertEquals(result.size(), computer.convert(result).size());
    }

    @Test
    void convertTest2() {
        Computer computer = new Computer();
        List<String> result = computer.validate("1 + 2* 5 - 8/4");
        Assertions.assertEquals(result.size(), computer.convert(result).size());
    }

}
