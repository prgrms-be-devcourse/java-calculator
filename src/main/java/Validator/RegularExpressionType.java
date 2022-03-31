package Validator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RegularExpressionType {
    OPERATION_EXPRESSION("[\\+\\-\\*\\/]"),
    NUMBER_EXPRESSION("\\d+"),
    REGULAR_EXPRESSION_TYPE("^((-?\\d*\\.?\\d+)[\\+\\-\\*\\/])+(-?\\d*\\.?\\d+)$"),
    ZERO_EXPRESS("^.*(/0).*");
   private final String regExp;
}
