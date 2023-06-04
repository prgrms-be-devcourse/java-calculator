package domain.repository;

import domain.model.Calculator;

import java.util.HashMap;
import java.util.Map;

public class CalculationRepository {

    Map<Long, Calculator> repository = new HashMap<>();
}
