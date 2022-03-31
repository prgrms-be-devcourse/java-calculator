package com.programmers.project;

import com.programmers.project.io.Console;
import com.programmers.project.repository.DataRepository;
import com.programmers.project.repository.VolatilityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class IOTest {

    Console console = new Console();

    @Test
    void 조회메뉴입력받기() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        console.menuMsg();
        String option = console.input();

        Assertions.assertEquals(input, option);

    }

}
