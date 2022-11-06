package app.io;

import app.calculator.Select;

// 사용자 입력값
public interface Input {
    Select selectInput();
    String calculateInput();
}
