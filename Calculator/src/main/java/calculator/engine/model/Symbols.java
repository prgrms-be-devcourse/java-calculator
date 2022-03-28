package calculator.engine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Symbols {
    private List<Double> operands = new ArrayList<Double>();
    private List<String> operators = new ArrayList<String>();
}
