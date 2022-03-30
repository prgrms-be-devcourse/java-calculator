package caculator.io;

import caculator.exception.WrongCalculatorMenuChoiceException;
import caculator.exception.WrongFormulaException;
import lombok.NoArgsConstructor;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class CalculatorIO extends IO {
    Scanner sc = null;

    public CalculatorIO() {
        this.sc = new Scanner(System.in);
    }

    public CalculatorIO(InputStream is) {
        this.sc = new Scanner(is);
    }

    @Override
    public int getNum() throws WrongCalculatorMenuChoiceException {
        int data;
        try {
            data = sc.nextInt();
            if (data != 1 && data != 2) {
                throw new Exception();
            }
            sc.nextLine();
        }
        catch (Exception e) {
            sc.nextLine();
            throw new WrongCalculatorMenuChoiceException("1과 2 중 하나만 선택하세요");
        }
        return data;
    }

    @Override
    public StringBuilder getLineWithNoSpaces() throws WrongFormulaException {
        String data;
        try {
            data = sc.nextLine();
            return new StringBuilder(data.replaceAll(" ",""));
        }
        catch (Exception e) {
            throw new WrongFormulaException("올바른 사칙 연산을 입력하세요.");
        }
    }

    @Override
    public void print(ArrayList<StringBuilder> list) {
        Optional<ArrayList<StringBuilder>> tmp = Optional.ofNullable(list);
        tmp.ifPresent((value)->{value.forEach(System.out::println);});
    }

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public void print(float msg) {
        System.out.println(new DecimalFormat("#.##").format(msg));
    }
}
