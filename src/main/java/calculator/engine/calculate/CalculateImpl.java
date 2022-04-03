package calculator.engine.calculate;

import calculator.engine.model.OperatorOrder;

import java.util.List;

import static calculator.engine.utils.Util.callExec;

public class CalculateImpl implements Calculate {

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

    public double calculate(Double[] nums, List<OperatorOrder> orderedOperators) {
        boolean[] visited = new boolean[nums.length];
        double result = 0;
        for (OperatorOrder data : orderedOperators) {
            int leftIdx = getLeft(data.getIdx() - 1, visited);
            int rightIdx = getRight(data.getIdx() + 1, visited);
            double a = nums[leftIdx];
            double b = nums[rightIdx];
            char sign = data.getSign();
            result = callExec(sign, a, b);
            visited[leftIdx] = true;
            nums[rightIdx] = result;
        }
        return nums[nums.length - 1];
    }

}
