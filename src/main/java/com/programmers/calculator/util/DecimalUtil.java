package com.programmers.calculator.util;

import java.text.DecimalFormat;

public final class DecimalUtil {

    private DecimalUtil() {}

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public static String formatToString(Number number) {
        return decimalFormat.format(number);
    }

}
