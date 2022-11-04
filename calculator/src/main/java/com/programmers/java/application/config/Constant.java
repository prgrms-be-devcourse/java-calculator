package com.programmers.java.application.config;

public class Constant {
    public static final String ALL_OPERATOR_REGEX = "[-+*/]+";
    public static final String ADD_MINUS_OPERATOR_REGEX = "[-+]+";
    public static final String NUMBER_REGEX = "-?\\d+(\\.\\d+)?";
    public static final String SPLIT_TOKENIZER_REGEX = "(?<=[-+*/])(?=.)|(?<=.)(?=[-+*/])";
    public static final String ADD_MINUS_NEXT_MULTIPLY_DIVIDE_OPERATOR_REGEX = ".*[-+*/]+[*/]+.*";
    public static final String DOUBLE_MULTIPLY_DIVIDE_OPERATOR_REGEX = "^[-+]?\\d*[*/]{2,}\\d*";
    public static final String ZERO_DIVIDE_REGEX = ".*\\/0([^.]|$|\\.(0{4,}.*|0{1,4}([^0-9]|$))).*";
    public static final String AVAILABLE_VALUE_REGEX = "(\\d{1,9}(\\.\\d{0,3})?)|[-+*/]";
    public static final String NUMBER_OPERATOR_REGEX = "^(\\d+(\\.\\d+)?|[-+/*])$";
}
