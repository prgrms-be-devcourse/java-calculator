package calculator.filter;
;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterImplTest {

    @DisplayName("올바른 값 유효성 검사")
    @Test
    void validate() {
        //given
        String s1 = "10/1+2*8";

        //when
        Filter filter = new FilterImpl();
        boolean v1 = filter.validate(s1);

        //then
        assertEquals(v1, true);
    }

    @DisplayName("올바르지 않은 값 유효성 검사")
    @Test
    void inValidate() {
        //given
        String s1 = "+1-1";
        String s2 = "1+2/3+";
        String s3 = "10/0";
        String s4 = "1++";
        String s5 = "a+@";

        //when
        Filter filter = new FilterImpl();
        boolean v1 = filter.validate(s1);
        boolean v2 = filter.validate(s2);
        boolean v3 = filter.validate(s3);
        boolean v4 = filter.validate(s4);
        boolean v5 = filter.validate(s5);

        //then
        assertEquals(v1, false);
        assertEquals(v2, false);
        assertEquals(v3, false);
        assertEquals(v4, false);
        assertEquals(v5, false);
    }
}