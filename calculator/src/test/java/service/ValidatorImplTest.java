package service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorImplTest {
    Validator validator = new Validator();

    @Test
    void 빈_문자열_입력시() {
        //given
        ArrayList<Object> list=new ArrayList<>();
        //then
        Assertions.assertThatThrownBy(() -> validator.validateFormat(list))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자_문자_비율이_맞지_않을때() {
        //given
        ArrayList<Object> list=new ArrayList<>();
        //when
        list.add(3.0);
        list.add("+");
        //then
        Assertions.assertThatThrownBy(() -> validator.validateFormat(list))
                .isInstanceOf(IllegalArgumentException.class);
    }
}