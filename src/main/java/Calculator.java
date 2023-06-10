import java.util.Scanner;
import java.util.Stack;

//계산을 실행하는 클래스
public class Calculator {

    //숫자,연산자를 입력받음
    Scanner scanner = new Scanner(System.in);
    Number result; //계산 결과

    int operand1 = scanner.nextInt(); //피연산자1
    String operator = scanner.nextLine(); //연산자
    int operand2 = scanner.nextInt(); //피연산자2

    public Number calculator() {

        //1. 연산자 우선순위를 계산함
        Stack<Object> stack = new Stack<>();

        for(int i = 0; i<operator.length();i++){
        }

        for(int i = 0; i<operator.length();i++){
        }

        int result; //계산 결과

        //

        //입력한 피연산자, 연산자에의한 계산을 수행하는 수식


    }

    //더하기 계산
    public Number Addtion(){
        result = operand1 + operand2;
        return result;
    }


    //빼기 계산
    public Number MinusCalaulator(){
        result = operand1 - operand2;
        return result;
    }

    //곱하기 계산
    public Number MultiplyCalculator(){
        result = operand1 * operand2;
        return result;
    }


    //나누기 계산
    public Number DivideCalculator(){
        result = operand1 / operand2;
        return result;
    }
}
