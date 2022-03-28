package calculator.engine;

import calculator.engine.io.Input;
import calculator.engine.io.Output;

import java.util.*;

import calculator.engine.model.History;
import calculator.engine.model.Symbols;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable {
    private Input input;
    private Output output;
    HashMap<String, Double> map = new HashMap<String, Double>();

    @Override
    public void run() {
        while (true) {
            // 사용하고자 하는 기능 선택
            System.out.println("\n1. 조회" + "\n2. 계산" + "\n3. 종료");
            int choice = Integer.parseInt(input.input("\n선택 : "));

            // 1. 조회
            if (choice == 1) output.History(map);

            // 2. 계산
            else if (choice == 2) {
                // 계산식을 입력받는다
                String inputString = input.input("\n");
                Symbols symbols = parse(inputString);

                // map 에 결과값을 저장
                History history = new History(inputString,
                        calculate(symbols.getOperands(),symbols.getOperators()));
                map.put(history.getFormula(), history.getCalculation());
                output.Calculation(history.getCalculation());
            }

            // 3. 종료
            else if (choice == 3) break;
        }
    }

    // 2-1. 입력받은 문자열을 띄어쓰기 단위로 parsing
    private Symbols parse(String inputString) {
        String[] newString = inputString.split("\\s+");

        // operand 와 operator 분리
        List<Double> operands = new ArrayList<Double>();
        List<String> operators = new ArrayList<String>();
        for (int i = 0; i < newString.length; i += 2) operands.add(Double.parseDouble(newString[i]));
        for (int i = 1; i < newString.length; i += 2) operators.add(newString[i]);
        Symbols symbols = new Symbols(operands,operators);

        return symbols;
    }

    // 2-2. 입력받은 연산식 계산
    private double calculate(List<Double> operands,List<String> operators) {
        // 곱하기,나누기 연산 수행
        int idx = 0; double temp;

        List<Double> newOperands = new ArrayList<Double>();
        newOperands.add(operands.get(0));
        operands.remove(0);

        while (operands.size() > 0) {
            if (operators.get(idx).equals("*")) {
                temp = newOperands.get(newOperands.size() - 1) * operands.get(0);
                newOperands.set(newOperands.size() - 1, temp);
                operators.remove(idx);
            } else if (operators.get(idx).equals("/")) {
                temp = newOperands.get(newOperands.size() - 1) / operands.get(0);
                newOperands.set(newOperands.size() - 1, temp);
                operators.remove(idx);
            } else {
                idx++; newOperands.add(operands.get(0));
            }
            operands.remove(0);
        }

        // 2-2-2. 더하기,빼기 연산 수행
        double calculation = newOperands.get(0);
        newOperands.remove(0);
        for(int i=0; i<operators.size(); i++) {
            if(operators.get(i).equals("+")){
                calculation += newOperands.get(0);
                newOperands.remove(0);
            }
            else if(operators.get(i).equals("-")){
                calculation -= newOperands.get(0);
                newOperands.remove(0);
            }
        }

        return calculation;
    }
}
