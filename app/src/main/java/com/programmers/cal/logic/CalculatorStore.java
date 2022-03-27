package com.programmers.cal.logic;

import java.util.List;

public class CalculatorStore {

    private final List<Formula> formulaStore;

    public CalculatorStore(List<Formula> formulaStore) {
        this.formulaStore = formulaStore;
    }

    public void save(Formula formula) {
        formulaStore.add(formula);
    }

    public List<Formula> selectAll() {
        return formulaStore;
    }

}
