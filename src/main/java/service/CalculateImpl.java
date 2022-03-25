package service;

import model.OperatorOrder;

import java.util.*;

import static utils.Operator.*;

public class CalculateImpl implements Calculate {

    private final Sorter sorter;

    public CalculateImpl(Sorter sorter) {
        this.sorter = sorter;
    }

    @Override
    public double calc(String command) {
        int result = 0;
        // 명령어 해석하면서 계산.

        System.out.println("command : " + command);

        String[] splitArr = command.split(" ");

        Double[] calculations = new Double[splitArr.length];
        List<OperatorOrder> orderOperList = new ArrayList<>();
        for (int i = 0; i < splitArr.length; i++) {
            if (i % 2 == 0)
                calculations[i] = Double.valueOf(splitArr[i]);
            else {
                orderOperList.add(new OperatorOrder(splitArr[i].charAt(0), i));
            }
        }
        sorter.sort(orderOperList);
        calculate(calculations, orderOperList);
        return calculations[calculations.length - 1];
    }

    private int getLeft(int idx, boolean[] visited) {
        while (idx > 0 && visited[idx]) {
            idx -= 2;
        }
        return idx;
    }

    private int getRight(int idx, boolean[] visited) {
        while (idx < visited.length - 1 && visited[idx]) {
            idx += 2;
        }
        return idx;
    }

    private void calculate(Double[] calculations, List<OperatorOrder> list) {
        boolean[] visited = new boolean[calculations.length];
        double result = 0;
        for (OperatorOrder data : list) {
            // System.out.println(Arrays.toString(calculations));
            int leftIdx = getLeft(data.getIdx() - 1, visited);
            int rightIdx = getRight(data.getIdx() + 1, visited);

            double a = calculations[leftIdx];
            double b = calculations[rightIdx];
            char sign = data.getSign();
            if (sign == MULTIPLY.getSign())
                result = MULTIPLY.exec(a, b);
            else if (sign == DIVISION.getSign()) {
                if (b == 0)
                    throw new RuntimeException("0으로 나눌 수 없습니다.");
                result = DIVISION.exec(a, b);
            }
            else if (sign == ADD.getSign())
                result = ADD.exec(a, b);
            else
                result = MINUS.exec(a, b);
            // System.out.printf("%f %c %f = %f\n", a, sign, b, result);
            visited[leftIdx] = true;
            calculations[rightIdx] = result;
        }
        // System.out.println("finish :" + Arrays.toString(calculations));
    }

}
