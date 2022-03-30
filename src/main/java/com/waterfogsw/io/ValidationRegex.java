package com.waterfogsw.io;

public class ValidationRegex {
    private ValidationRegex() {
        // 유틸리티 클래스
    }

    static final String FORMULA_REGEX = "^\\s*([\\(\\)]\\s+)*([-+]?)(\\d+)(.{1}\\d+)?(?:\\s+([-+*\\/])\\s+([\\(\\)]\\s+)*([-+]?)(\\d+)(.{1}\\d+)?(\\s+[\\(\\)])*\\s*)+$";
    static final String MENU_REGEX = "([^12])|(1{2,})|(2{2,})|(12+)|(21+)";
}
