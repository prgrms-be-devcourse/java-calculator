package com.programmers.java.engine;

import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;
import com.programmers.java.engine.model.History;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Calculator implements Runnable{

    private Input input;
    private Output output;
    private History history;

    enum Menu{
        EXIT(0, "종료"), LOOKUP(1, "조회"), CALCULATE(2, "계산");

        private final int value;
        private final String prompt;

        Menu(int value, String prompt) {
            this.value=value;
            this.prompt=prompt;
        }

        @Override
        public String toString(){
            return prompt;
        }
    }

    @Override
    public void run() {
        String menus="";
        //+= 사용은 메모리적인 측면에서 비효율적이지만 초기 부분에서만 일어나기 때문에 사용함.
        for(Menu m : Menu.values()){
            menus+=m.ordinal()+"."+m.toString()+"\n";
        }

        final int EXIT=Menu.EXIT.ordinal();
        final int LOOKUP=Menu.LOOKUP.ordinal();
        final int CALCULATE=Menu.CALCULATE.ordinal();

        while(true){
            System.out.println(menus);
            int userOption=input.input("선택 : ");
            if(userOption==EXIT){
                System.out.println("exit");
                break;
            }
            else if(userOption==LOOKUP){
                System.out.println("조회함");
            }
            else if(userOption==CALCULATE){
                System.out.println("계산함");
            }
            else{
                output.inputError();
                continue;
            }
        }
    }
}
