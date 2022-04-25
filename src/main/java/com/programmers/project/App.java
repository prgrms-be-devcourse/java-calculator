package com.programmers.project;

import com.programmers.project.io.Console;
import com.programmers.project.repository.DataRepository;
import com.programmers.project.repository.VolatilityRepository;

import static java.lang.System.exit;

public class App {
    private Calculator calculator = new Calculator(); // 계산기
    private DataRepository repository = new VolatilityRepository(); // 저장소
    private Console console = new Console(); // 입출력

    void start(){
        while(true){
            console.menuMsg(); // 메뉴메세지
            String opt = console.input(); // 메뉴옵션받기

            if(opt.equals("1")){ // 조회
                for(String record : repository.getAllRecords()){
                    console.print(record);
                }
            }
            else if(opt.equals("2")) { // 계산
                String formula = console.input();
                double result = calculator.calculate(formula);
                repository.add(formula+ " = " + result); // 입력식과 결과 저장
                console.print(Double.toString(result));
            }
            else{  // 종료
                console.exitMsg();
                exit(0);
            }
        }
    }
}
