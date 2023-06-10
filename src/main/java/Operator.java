

//계산에 필요한 연산자를 구분,수행하기 위한 클래스
public class Operator {
    //넘겨받은 피연산자를 통해 계산을 받음
    private int operator1;
    private int operator2;

    public Operator(int operator1, int operator2) {
        this.operator1 = operator1;
        this.operator2 = operator2;
    }

    //Setter

    public void setOperator1(int operator1) {
        this.operator1 = operator1;
    }

    public void setOperator2(int operator2) {
        this.operator2 = operator2;
    }


    //Getter

    public int getOperator1() {
        return operator1;
    }

    public int getOperator2() {
        return operator2;
    }


    //operator.calculator(operator1,opertaor2) //계산하는 방식

    //계산
    public  void  addition(int inputNumber1, int inputNumber2){
        //1. 연산자 우선순위 체크
        //2. 연산자 덧셈
        //3. Memroizer에 기억하도록 저장함
        // 반환함

    }

    //뺄셈 메소드
    public void minus(int inputNumber1, int inputNumber2) {
        //1. 연산자 우선순위 체크
        //2. 연산자 뺄셈
        //3. Memroizer에 기억하도록 저장함
        // 반환함
    }
}
