package service;

import entity.Data;
import repository.CalculatorRepository;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
    private final CalculatorRepository calculatorRepository;

    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    // 계산 로직
    public String calculate(String calculationFormula){

        List<String> list = createList(calculationFormula);

        if (list.contains("*")||list.contains("/")) calc(list, "*", "/");

        if (list.contains("+")||list.contains("-")) calc(list, "+","-");

        String result = list.get(0);
        return result;
    }

    // 조회 로직
    public void showAllResult(){
        List<Data> dataList = calculatorRepository.findAll();
        if (dataList.isEmpty()){
            System.out.println("조회할 값이 없습니다.");
        }
        else {
            for (Data data : dataList) {
                System.out.println(data.getCalculationFormula() + " = " + data.getResult());
            }
        }
    }

    public String saveResult(Data data) {
        String saveResult = calculatorRepository.save(data);
        return saveResult;
    }

    private List<String> createList(String calculationFormula) {
        String[] spaceSplitArray = calculationFormula.split(" ");

        List<String> list = new ArrayList<>();
        for (String spaceSplitValue : spaceSplitArray) {
            list.add(spaceSplitValue);
        }
        return list;
    }

    private void calc(List<String> list, String operator1, String operator2) {

        for (int operatorIndex = 1; operatorIndex < list.size(); operatorIndex += 2) {
            String formulaOperator = list.get(operatorIndex);

            if (formulaOperator.equals(operator1) || formulaOperator.equals(operator2)) {
                double b = Double.parseDouble(list.remove(operatorIndex + 1));
                list.remove(operatorIndex);
                double a = Double.parseDouble(list.remove(operatorIndex - 1));

                if (formulaOperator.equals("*")) {
                    list.add(operatorIndex - 1, String.valueOf(a * b));
                } else if (formulaOperator.equals("/")) {
                    list.add(operatorIndex - 1, String.valueOf(a / b));
                } else if (formulaOperator.equals("+")) {
                    list.add(operatorIndex - 1, String.valueOf(a + b));
                } else {
                    list.add(operatorIndex - 1, String.valueOf(a - b));
                }

                operatorIndex -= 2;
            }
        }

    }
}