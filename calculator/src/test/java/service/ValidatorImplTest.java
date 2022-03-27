package service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorImplTest {
    Validator validator = new ValidatorImpl();

    @Test
    void 빈_리스트_사이즈() {
        //given
        ArrayList<Object> list=new ArrayList<>();
        //then
        Assertions.assertThatThrownBy(() -> validator.validateFormat(list))
                .isInstanceOf(EmptyStackException.class);
    }
    @Test
    void 짝수_리스트_사이즈() {
        //given
        ArrayList<Object> list=new ArrayList<>();
        //when
        list.add(3.0);
        list.add("+");
        //then
        Assertions.assertThatThrownBy(() -> validator.validateFormat(list))
                .isInstanceOf(EmptyStackException.class);
    }
}