package model.converter;

import model.vo.Expression;

import java.util.List;

public interface Converter {
    List<String> covert(Expression expression);
}
