package model.converter;

import model.vo.Expression;

import java.util.List;

public interface Converter {
    List<String> convert(Expression expression);
}
