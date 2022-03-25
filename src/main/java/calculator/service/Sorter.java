package calculator.service;

import calculator.engine.model.OperatorOrder;

import java.util.List;

public interface Sorter {
    List<OperatorOrder> sort(List<OperatorOrder> list);
}
