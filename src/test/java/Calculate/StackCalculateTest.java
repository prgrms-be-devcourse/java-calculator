package Calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;

class StackCalculateTest {

    private final Calculate calculate = new StackCalculate();

    @DisplayName("1+2 = 3 이다.")
    @ValueSource(strings = {"1+2","2+1"})
    @ParameterizedTest
    void _1(String s) {
        long result = calculate.calc(s);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("1+2 = 4가 아니다.")
    @Test
    void _2() {
        String s = "1+2";
        long result = calculate.calc(s);
        assertThat(result).isNotEqualTo(4);
    }

    @DisplayName("2*3 = 6 이다.")
    @ValueSource(strings = {"2*3","3*2"})
    @ParameterizedTest
    void _3(String s) {
        assertThat(calculate.calc(s)).isEqualTo(6);
    }

    @DisplayName("4*3 = 8이 아니다.")
    @Test
    void _4() {
        String s = "4*3";
        assertThat(calculate.calc(s)).isNotEqualTo(8);
    }

    @ParameterizedTest
    @DisplayName("1+2*3 = 7 이다")
    @ValueSource(strings = {"2*3+1","1+2*3"})
    void _5(String s) {
        assertThat(calculate.calc(s)).isEqualTo(7);
    }

    @ParameterizedTest
    @DisplayName("1+2*3-1 = 6 이다")
    @ValueSource(strings = {"2*3+1-1","1+2*3-1"})
    void _6(String s) {
        assertThat(calculate.calc(s)).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("1+3*5/5-6 = -2이다")
    @ValueSource(strings = {"1+3*5/5-6", "5/5*3-6+1"})
    void _7(String s) {
        assertThat(calculate.calc(s)).isEqualTo(-1 * 2);
    }


}