package com.programmers;

import com.programmers.engine.PageManager;
import com.programmers.engine.caculator.Caculator;
import com.programmers.engine.caculator.PostfixCaculator;
import com.programmers.engine.parser.StartParser;
import com.programmers.engine.parser.caculator.PostfixCaculatorParser;
import com.programmers.engine.repository.MemoryRepository;
import com.programmers.engine.repository.HistoryRepository;
import com.programmers.pages.*;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Map<PageList, Page> pages = new HashMap<>();
        HistoryRepository myRepository = new MemoryRepository();
        MypageFactory mypageFactory = new MypageFactory(myRepository);

        for (PageList key : PageList.values()) {
            pages.put(key, mypageFactory.createPage(key));
        }
        PageManager pageManager = new PageManager(pages, PageList.START);
        pageManager.run();
    }

    static class MypageFactory implements PageFactory {
        HistoryRepository myRepo;

        MypageFactory(HistoryRepository reopsitory) {
            this.myRepo = reopsitory;
        }

        @Override
        public Page createPage(PageList type) {
            {

                switch (type) {
                    case START -> {
                        return StartPage.builder()
                                .content("1.조회\n2.계산\n3.종료")
                                .prompt("선택 : ")
                                .parser(new StartParser())
                                .nextPage(PageList.NONE)
                                .build();
                    }
                    case LOOKUP -> {
                        return LookupPage.builder()
                                .content("저장된 값이 없습니다.")
                                .prompt("선택 페이지로 돌아가기위해 아무 키나 눌러주세요...")
                                .repo(myRepo)
                                .nextPage(PageList.START)
                                .build();
                    }
                    case CALCULATE -> {
                        return CaculatePage.builder()
                                .content("계산 페이지 입니다.")
                                .prompt("식을 입력해 주세요 : ")
                                .repo(myRepo)
                                .parser(new PostfixCaculatorParser())
                                .caculator(new PostfixCaculator())
                                .nextPage(PageList.START)
                                .build();
                    }
                    default -> {
                        return null;
                    }
                }
            }
        }
    }
}