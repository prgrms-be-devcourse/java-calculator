import java.util.Optional;

public interface ICalculator {
    default Double add(Double a, Double b) { return a+b; }
    default Double sub(Double a, Double b) { return b-a; }
    default Double mul(Double a, Double b){
        return a*b;
    }
    default Double div(Double a, Double b) { return b/a; }
}
