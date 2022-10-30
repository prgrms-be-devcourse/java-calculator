package com.programmers.config;

import com.programmers.caculation.CaculateService;
import com.programmers.caculation.CaculationController;
import com.programmers.caculation.ParseService;
import com.programmers.caculation.TokenizeService;
import com.programmers.caculation.caculator.Caculator;
import com.programmers.caculation.caculator.PostfixCaculator;
import com.programmers.caculation.parser.Parser;
import com.programmers.caculation.parser.PostfixParser;
import com.programmers.caculation.toeknizer.NumberOpTokenizerUsingCharArray;
import com.programmers.caculation.toeknizer.Tokenizer;
import com.programmers.io.Console;
import com.programmers.record.RecordController;
import com.programmers.repository.HistoryRepository;
import com.programmers.repository.MemoryRepository;

public class AppConfig {
    private AppConfig(){}
    private static final HistoryRepository myRepository= new MemoryRepository();
    private static final Tokenizer tokenizer = new NumberOpTokenizerUsingCharArray();
    private static final TokenizeService tokenizeService = new TokenizeService(tokenizer);
    private static final Parser parser = new PostfixParser();
    private static final ParseService parseService = new ParseService(parser);
    private static final Caculator caculator = new PostfixCaculator();
    private static final CaculateService caculateService = new CaculateService(caculator);

    public static final Console myConsole = new Console();

    public static final CaculationController caculationController =
            CaculationController.builder()
                    .tokenizeService(tokenizeService)
                    .parseService(parseService)
                    .caculateService(caculateService)
                    .historyRepository(myRepository)
                    .build();
    public static final RecordController recordController =
            RecordController.builder()
                    .historyRepository(myRepository)
                    .build();
}
