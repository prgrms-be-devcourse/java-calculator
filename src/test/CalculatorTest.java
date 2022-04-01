import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.cal.calculator.Calculator;
import src.cal.storage.MemoryStorage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator myCal = new Calculator();

    @Test
    @DisplayName("계산기 test case 실행")
    void allTest() throws IOException {
        //read file
        ArrayList<String> calTestCaseList = getTestCaseList("src/test/calTestCase.txt");
        for (String calTestCase : calTestCaseList) {
            String[] splitedCalTestCase = calTestCase.split("=");
            String expCalTestCase = splitedCalTestCase[0];
            double resultCalTestCase = Double.parseDouble(splitedCalTestCase[1]);

            testCal(expCalTestCase, resultCalTestCase);
        }
    }

    @Test
    @DisplayName("MemoryStorage Test")
    void storageTest() throws IOException {
        MemoryStorage myStorage = new MemoryStorage();
        ArrayList<String> calTestCaseList = getTestCaseList("src/test/calTestCase.txt");

        for (String calTestCase : calTestCaseList) {
            String[] splitedCalTestCase = calTestCase.split("=");
            String expCalTestCase = splitedCalTestCase[0];
            double resultCalTestCase = Double.parseDouble(splitedCalTestCase[1]);

            myStorage.add(expCalTestCase, resultCalTestCase);
        }

        assertEquals(calTestCaseList, myStorage.getAll());
    }


    public static ArrayList<String> getTestCaseList(String filepath) throws IOException {
        ArrayList<String> calTestCaseList = new ArrayList<>();
        File file = new File(filepath);
        if(file.exists())
        {
            BufferedReader inFile = new BufferedReader(new FileReader(file));
            String sLine = null;
            while( (sLine = inFile.readLine()) != null ) {
                char commentCharInTestCase = sLine.charAt(0);
                String commentStrInTestCase = String.valueOf(commentCharInTestCase);
                if (commentStrInTestCase.equals("-")) {
                    continue;
                }
                calTestCaseList.add(sLine);
            }
        }
        return calTestCaseList;
    }

    void testCal(String exp, double expected) {
        double calResult = myCal.compute(exp);
        if (expected == calResult) {
            System.out.printf("[passed] %s = %f \n", exp ,expected);
        } else {
            System.out.printf("[failed] %s = %f \n", exp ,expected);
            assertEquals(expected, calResult);
        }
    }
}
