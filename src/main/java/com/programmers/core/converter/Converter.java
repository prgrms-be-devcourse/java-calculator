package com.programmers.core.converter;

import com.programmers.core.data.CalculationRequest;

import java.util.List;

public interface Converter {
    List<String> convert(CalculationRequest formula);
}
