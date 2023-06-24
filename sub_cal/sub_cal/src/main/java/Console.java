import io.Input;
import io.Output;
import option.Option;
import validation.InputValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Console implements Input,  Output {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public Option selectOption() {
        try{
            return selectOptionValue(br.readLine());
        }catch (IOException e){
            return Option.EXIT;
        }

    }

    private Option selectOptionValue(String inputNumber) throws IOException {
        Optional<Option> userOption = Option.getMenu(inputNumber);
        if(InputValidation.isValidMenuNumber(userOption)) {
            printInvalidMenuErrorMessage();
            throw new IOException();
        }

        return userOption.get();
    }

    @Override
    public String inputExpression(){
        try {
            String Expression = br.readLine();
            if(InputValidation.isEmptyInputExpression(Expression)){
                printEmptyInputExpressionMessage();
                throw new IOException();
            }
            return Expression;
        }catch (IOException e){
            return null;
        }

    }

    @Override
    public void historyEmptyError() {
        System.out.println("조회된 데이터가 없습니다.");
    }

    @Override
    public boolean showResultHistory(List<String> historyList) {
        if(historyList.isEmpty()) return false;
        for (String s : historyList) {
            System.out.println(s);
        }

        return true;
    }

    @Override
    public void printMenuList() {
        Arrays.stream(Option.values()).forEach(o -> System.out.println(o));
    }


    private void printInvalidMenuErrorMessage() {
        System.out.println("존재하지 않는 메뉴입니다.");
    }


    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printInputExpressionMessage() {
        System.out.println("계산식을 입력해주세요:");
    }


    private void printEmptyInputExpressionMessage() {
        System.out.println("수식을 입력해주세요.");
    }
}
