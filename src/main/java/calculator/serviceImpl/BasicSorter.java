package calculator.serviceImpl;

import calculator.engine.model.OperatorOrder;
import calculator.service.Sorter;
import calculator.engine.utils.Util;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BasicSorter implements Sorter {
    @Override
    public List<OperatorOrder> sort(List<OperatorOrder> list) {
        Map<Character, Integer> orderMap = Util.getOperatorMap();
        Collections.sort(list, (o1, o2) -> {
            int order = orderMap.get(o1.getSign()) - orderMap.get(o2.getSign());
            if (order == 0) {
                order = o1.getIdx() - o2.getIdx();
            }
            return order;
        });
        return list;
    }
}
