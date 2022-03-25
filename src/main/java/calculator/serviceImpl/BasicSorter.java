package calculator.serviceImpl;

import calculator.engine.model.OperatorOrder;
import calculator.engine.utils.Operator;
import calculator.service.Sorter;
import calculator.engine.utils.Util;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BasicSorter implements Sorter {
    @Override
    public List<OperatorOrder> sort(List<OperatorOrder> list) {
        Map<Character, Operator> orderMap = Util.getOperatorMap();
        Collections.sort(list, (o1, o2) -> {
            Operator op1 = orderMap.get(o1.getSign());
            Operator op2 = orderMap.get(o2.getSign());
            int order = op1.getOrder() - op2.getOrder();
            if (order == 0) {
                order = o1.getIdx() - o2.getIdx();
            }
            return order;
        });
        return list;
    }
}
