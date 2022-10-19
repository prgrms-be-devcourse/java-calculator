package caculator.io;

import caculator.exception.WrongCalculatorMenuChoiceException;
import caculator.exception.WrongFormulaException;

import java.util.Scanner;

public interface Input {
    public int getNum() throws WrongCalculatorMenuChoiceException;

    public StringBuilder getLineWithNoSpaces() throws WrongFormulaException;
}
