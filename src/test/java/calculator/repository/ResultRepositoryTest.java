package calculator.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultRepositoryTest {

    @BeforeEach
    void beforeEach() {
        ResultRepositoryImpl.getInstance().clearAll();
    }

    @DisplayName("클래스가 싱글톤으로 생성 되었는지 테스트")
    @Test
    void testSingleton() {
        // singleton이기 때문에 같은 객체
        assertEquals(ResultRepositoryImpl.getInstance(), ResultRepositoryImpl.getInstance());
    }

    @DisplayName("isCalculated() 테스트")
    @Test
    void testIsCalculated() {
        ResultRepositoryImpl.getInstance().saveResult("1 + 2", 3);

        assertTrue(ResultRepositoryImpl.getInstance().isCalculated("1 + 2"));
        assertFalse(ResultRepositoryImpl.getInstance().isCalculated("1 + 2 + 3"));
    }

    @DisplayName("getResult() 테스트")
    @Test
    void testGetResult() {
        String expr = "1 + 2";
        Integer exprResult = 3;
        ResultRepositoryImpl.getInstance().saveResult(expr, exprResult);

        assertEquals(ResultRepositoryImpl.getInstance().getResult(expr), exprResult);
    }

    @DisplayName("saveResult() 테스트")
    @Test
    void testSaveResult() {
        String expr1 = "1 + 2";
        Integer exprResult1 = 3;
        String expr2 = "2 + 3";
        Integer exprResult2 = 6;

        ResultRepositoryImpl.getInstance().saveResult(expr1, exprResult1);
        ResultRepositoryImpl.getInstance().saveResult(expr2, exprResult2);

        assertEquals(ResultRepositoryImpl.getInstance().size(), 2);
    }
}