package org.example.view;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class View implements Input,Output{

    private final Scanner sc = new Scanner(System.in);
    private static final Pattern REGEX_EXPRESSION = Pattern.compile("\\d+(\\s[+\\-*/]\\s\\d+)*");

    @Override
    public int select() {
        int selection = sc.nextInt();

        if (validateSelection(selection)) {
            sc.nextLine();
            return selection;
        }

        return -1;
    }

    @Override
    public String inputExpression() {
        String expression = sc.nextLine();

        if (validateExpression(expression)) {
            return expression;
        }
        //의도하신 부분이 맞는 건지 혼동되는 부분
        throw new IllegalArgumentException("수식을 정확하게 입력하지 않으셨습니다.");
    }

    @Override
    public void printSelection(){
        for(SelectTypeView stv : SelectTypeView.values()){
            System.out.println(stv.getNum() + " " + stv.getOption());
        }
        System.out.println();
        System.out.print("선택 : ");
    }

    @Override
    public void printResult(double result) {
        System.out.println(result);
    }

    @Override
    public void printRecords(List<String> arithmeticRecords) {
        arithmeticRecords.stream().forEach(System.out::println);
    }

    private boolean validateSelection(int selection) {
        System.out.println(selection);
        for(SelectTypeView stv : SelectTypeView.values()){
            if(stv.getNum() == selection){
                return true;
            }
        }
        return false;
    }

    public boolean validateExpression(String expression) {
        return REGEX_EXPRESSION.matcher(expression).matches();
    }
}
