import java.util.Optional;

public interface ICalculator {
    default Double add(Double a, Double b) { return a+b; }
    default Double sub(Double a, Double b) { return b-a; }
    default Double mul(Double a, Double b){
        return a*b;
    }
    default Double div(Double a, Double b) { return b/a; }

    static boolean isOperator(char ch) {
        if (ch == '*' || ch == '/' || ch == '+' || ch == '-') return true;
        return false;
    }
    static int priority(char ch) {
        if(ch == '+' || ch =='-') return 1;
        if(ch == '*' || ch =='/') return 2;
        return 0;
    }
}
