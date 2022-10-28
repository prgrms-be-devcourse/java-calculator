package com.programmers.caculation.caculator;

import com.programmers.caculation.model.NumberAndOperator;

import java.util.Collection;

public interface Caculator {
    public Double caculate(Collection<NumberAndOperator> operatorAndNumbersSortedByPostfix) throws Exception;

}
