package com.prgrms.ndy;

import com.prgrms.ndy.io.BufferedReaderWriter;
import com.prgrms.ndy.parsor.RegexParser;
import com.prgrms.ndy.repository.HashMapCalculationRepository;

public class Application {

    public static void main(String[] args) throws Exception {

        new Calculator(
                new RegexParser(),
                new BufferedReaderWriter(),
                new HashMapCalculationRepository()
        )
                .run();
    }

}
