package com.prgrms.ndy;

import com.prgrms.ndy.io.BufferedReaderWriter;
import com.prgrms.ndy.parsor.RegexParser;
import com.prgrms.ndy.repository.H2CalculationRepository;

public class Application {

    public static void main(String[] args) throws Exception {

        AppInitializer appInitializer = new AppInitializer();
        appInitializer.init();

        new Calculator(
                new RegexParser(),
                new BufferedReaderWriter(),
                new H2CalculationRepository(appInitializer.getDataSource())
        )
                .run();
    }

}
