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
        String result = "2 + 3 = 5";

        //when
        repository.save(result);

        //then
        assertThat(repository.findById(0L)).isEqualTo(result);
    }

    @Test
    void testPrint() {
        //given
        String arithmetic = "2 + 3 = 5";
        String arithmetic2 = "8 * 20 = 160";
        String arithmetic3 = "-3 - -5 = 2";

        String result = "2 + 3 = 5" + lineSeparator() + "8 * 20 = 160" + lineSeparator() + "-3 - -5 = 2";

        //when
        repository.save(arithmetic);
        repository.save(arithmetic2);
        repository.save(arithmetic3);
        repository.printLog();

        //then
        assertThat(outputStream.toString().trim()).isEqualTo(result);
    }
}
