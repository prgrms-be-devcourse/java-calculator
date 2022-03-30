package caculator.io;

import caculator.exception.WrongCalculatorMenuChoiceException;
import caculator.exception.WrongFormulaException;

import java.util.ArrayList;

public class IO implements Input, Output {
    @Override
    public int getNum() throws WrongCalculatorMenuChoiceException {
        return 0;
    }

    @Override
    public StringBuilder getLineWithNoSpaces() throws WrongFormulaException {
        return null;
    }

    @Override
    public void print(ArrayList<StringBuilder> list) {}

    @Override
    public void print(String msg) {}

    @Override
    public void print(float msg) {}
}