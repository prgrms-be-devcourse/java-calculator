package com.programmers.java.calculator;

import com.programmers.java.calculator.engine.repository.LogRepository;
import com.programmers.java.calculator.engine.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.System.lineSeparator;
import static org.assertj.core.api.Assertions.assertThat;

public class RepositoryTest {
    Repository repository = new LogRepository();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    private void before() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testSave() {
        //given
        repository.save("2 + 3 = 5");

        String result = "2 + 3 = 5";

        //then
        assertThat(repository.findById(0L)).isEqualTo(result);
    }

    @Test
    void testPrint() {
        //given
        repository.save("2 + 3 = 5");
        repository.save("8 * 20 = 160");
        repository.save("-3 - -5 = 2");
        repository.printLog();

        String result = "2 + 3 = 5" + lineSeparator() + "8 * 20 = 160" + lineSeparator() + "-3 - -5 = 2";

        //then
        assertThat(outputStream.toString().trim()).isEqualTo(result);
    }
}
