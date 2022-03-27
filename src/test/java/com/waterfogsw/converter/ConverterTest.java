package com.waterfogsw.converter;

import com.waterfogsw.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ConverterTest {
    private Converter converter;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        converter = appConfig.converter();
    }

    @Test
    public void 후위표기식_변환_테스트_1() throws Exception {
        // given
        List<String> infix = new ArrayList<>(Arrays.asList("1", "+", "2", "+", "3"));

        // when
        List<String> postfix = converter.convert(infix);

        // then
        Assertions.assertThat(postfix).isEqualTo(Arrays.asList("1", "2", "+", "3", "+"));
    }

    @Test
    public void 후위표기식_변환_테스트_2() throws Exception {
        // given
        List<String> infix = new ArrayList<>(Arrays.asList("1", "-", "2", "-", "3"));

        // when
        List<String> postfix = converter.convert(infix);

        // then
        Assertions.assertThat(postfix).isEqualTo(Arrays.asList("1", "2", "-", "3", "-"));
    }

    @Test
    public void 후위표기식_변환_테스트_3() throws Exception {
        // given
        List<String> infix = new ArrayList<>(Arrays.asList("2", "/", "(", "2", "+", "2", ")"));

        // when
        List<String> postfix = converter.convert(infix);

        // then
        Assertions.assertThat(postfix).isEqualTo(Arrays.asList("2", "2", "2", "+", "/"));
    }

    @Test
    public void 후위표기식_변환_테스트_4() throws Exception {
        // given
        List<String> infix = new ArrayList<>(Arrays.asList("(", "4", "-", "2", ")", "*", "2"));

        // when
        List<String> postfix = converter.convert(infix);

        // then
        Assertions.assertThat(postfix).isEqualTo(Arrays.asList("4", "2", "-", "2", "*"));
    }

    @Test
    public void 후위표기식_변환_테스트_5() throws Exception {
        // given
        List<String> infix = new ArrayList<>(Arrays.asList("-", "100", "+", "300"));

        // when
        List<String> postfix = converter.convert(infix);

        // then
        Assertions.assertThat(postfix).isEqualTo(Arrays.asList("100", "-", "300", "+"));
    }

}