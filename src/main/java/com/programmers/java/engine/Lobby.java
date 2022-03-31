package com.programmers.java.engine;

import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;
import com.programmers.java.engine.io.exception.*;
import com.programmers.java.engine.model.Calculator;
import com.programmers.java.engine.model.Expression;
import com.programmers.java.engine.model.History;
import com.programmers.java.engine.model.Operator;
import lombok.AllArgsConstructor;

import java.util.Optional;

enum Menu{
    EXIT("종료"),
    LOOKUP("조회"),
    CALCULATE("계산");

    private final String prompt;

    Menu(String prompt) {
        this.prompt=prompt;
    }

    @Override
    public String toString(){
        return prompt;
    }
}

//TODO : Parsing Test 코드 작성
//TODO : 바깥에서 유효성검사를 했다면 호출한 함수 속에서는 검사를 하지 않아도 되는건가요? 해야된다면 어느 깊이까지 해야하나요?

@AllArgsConstructor
public class Lobby implements Runnable{

    private Input input;
    private Output output;
    private History history;
    private Calculator calculator;

    @Override
    public void run() {
        StringBuilder menus= new StringBuilder();
        for(Menu m : Menu.values()){
            menus.append(m.ordinal()).append(".").append(m).append("\n");
        }

        final int EXIT=Menu.EXIT.ordinal();
        final int LOOKUP=Menu.LOOKUP.ordinal();
        final int CALCULATE=Menu.CALCULATE.ordinal();

        while (true) {
            try {
                System.out.println('\n' + menus.toString());

                int userOption = input.optionInput("선택 : ");
                if (userOption == EXIT) {
                    output.exitMessage();
                    break;
                } else if (userOption == LOOKUP) {
                    history.searchAll();
                } else if (userOption == CALCULATE) {
                    output.informFormat();
                    String userStr = input.strInput("계산식을 입력해주세요 : ");
                    Optional<String[]> parsedUserStr = parse(userStr);
                    if(parsedUserStr.isEmpty()) throw new ParsedException();
                    String ans = calculator.calculate(parsedUserStr.get());
                    System.out.println(ans);
                    history.save(new Expression(userStr, ans));
                } else {
                    output.inputError();
                }
            }catch(Exception e){
                output.errorMessage(e);
            }
        }

    }

    public Optional<String[]> parse(String userStr) throws Exception{
        if(userStr.length()%2==0) throw new ParsedException();

        String[] parsedStr= userStr.split(" ");
        for(String str : parsedStr){
            try {
                Optional<Operator> arg = Operator.getOperator(str);
                if (arg.isEmpty()) {
                    Double.parseDouble(str);
                }
            } catch(NumberFormatException nfe){
                throw new ParsedException();
            }
        }
        return Optional.of(parsedStr);
    }
}
