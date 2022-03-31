package com.programmers.project;

import com.programmers.project.io.Console;
import com.programmers.project.repository.DataRepository;
import com.programmers.project.repository.VolatilityRepository;

public class App {
    private Calculator calculator = new Calculator(); // 계산기
    private DataRepository repository = new VolatilityRepository(); // 저장소
    private Console console = new Console(); // 입출력

    void start(){
        while(true){
            console.menuMsg();
            String opt = console.input();

            if(opt.equals("1")){ // 조회
                for(String record : repository.getAllRecords()){
                    console.print(record);
                }
            }
            else{ // 계산
                String formula = console.input();
                double result = calculator.calculate(formula);
                repository.add(formula+ " = " + result);
                console.print(Double.toString(result));
            }
        }
    }
}
