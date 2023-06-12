import io.Input;
import io.Output;
import model.Calculator;
import model.History;
import model.Operator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//프로그램이 실행되면 가장 먼저 실행되는 메인 클래스입니다.
//Index 생성자에 필요한 객체들을 넣어줍니다.
public class Main {
    public static void main(String[] args) {
        new Index(new Console(),new History(),new Calculator()).run();

    }



}
