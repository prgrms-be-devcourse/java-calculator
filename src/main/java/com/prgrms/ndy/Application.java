package com.prgrms.ndy;

import com.prgrms.ndy.io.BufferedReaderWriter;
import com.prgrms.ndy.parsor.RegexParser;

public class Application {

    public static void main(String[] args) {
        new Calculator(
                new RegexParser(),
                new BufferedReaderWriter()
        )
                .run();
    }
}
