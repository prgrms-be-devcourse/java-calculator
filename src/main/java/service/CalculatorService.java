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

        StringBuilder sb = new StringBuilder();
        String result = sb.append(list.get(0)).toString();

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
        String[] s = calculationFormula.split(" ");

        List<String> list = new ArrayList<>();
        for (String s1 : s) {
            list.add(s1);
        }
        return list;
    }

    private void calc(List<String> list, String operator1, String operator2) {

        for (int i = 1; i < list.size(); i+=2) {

            String s = list.get(i);

            if (s.equals(operator1)||s.equals(operator2)) {
                double b = Double.parseDouble(list.remove(i + 1));
                list.remove(i);
                double a = Double.parseDouble(list.remove(i - 1));

                if (s.equals("*")) {
                    list.add(i - 1, String.valueOf(a * b));
                } else if (s.equals("/")) {
                    list.add(i - 1, String.valueOf(a / b));
                } else if (s.equals("+")) {
                    list.add(i - 1, String.valueOf(a + b));
                } else {
                    list.add(i - 1, String.valueOf(a - b));
                }

                i -= 2;
            }
        }

    }
}
