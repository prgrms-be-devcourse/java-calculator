package service;

import model.OperatorOrder;

import java.util.List;

public interface Sorter {
    List<OperatorOrder> sort(List<OperatorOrder> list);
}
