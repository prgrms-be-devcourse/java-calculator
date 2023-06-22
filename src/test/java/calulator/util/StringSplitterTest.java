package calulator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StringSplitterTest {

    @DisplayName("문자열을 연산기호를 기준으로 나눈다.")
    @Test
    void split() {
        String str = "1+2-3*4/5";

        List<String> expressions = List.of("1", "+" , "2" , "-" , "3" ,"*" ,"4" , "/" , "5");

        assertThat(StringSplitter.splitByOperator(str)).isEqualTo(expressions);
    }

}
