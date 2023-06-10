

//연산자 우선순위를 구분
public class Operator {
    public int priority(String operator){
        if(operator.equals('+')||operator.equals('-'))
            return 1;
        else if (operator.equals('*')||operator.equals('-')) {
            return 2;
        }
        return -1;
    }
}
