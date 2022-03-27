package calculator.engine.io;

import java.util.HashMap;

public interface Output {
    void Calculation(double result);
    void History(HashMap<String, Double> map);
}
