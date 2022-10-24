package com.programmers;

import com.programmers.engine.PageManager;
import com.programmers.engine.caculator.Caculator;
import com.programmers.engine.caculator.PostfixCaculator;
import com.programmers.engine.repository.MemoryRepository;
import com.programmers.engine.repository.Repository;
import com.programmers.pages.*;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        MypageFactory mypageFactory = new MypageFactory();
        Map<PageList, Page> pages = new HashMap<>();
        Repository myRepository  = new MemoryRepository();
        Caculator myCaculator = new PostfixCaculator();

        for (PageList key : PageList.values()) {
            pages.put(key, mypageFactory.createPage(key));
        }
        new PageManager(myRepository,myCaculator,pages,PageList.START).run();
    }

    static class MypageFactory implements PageFactory {
        @Override
        public Page createPage(PageList type) {
            {
                switch (type) {
                    case START -> {
                        StartPage.builder().content("1.조회\n2.계산").prompt("선택").build();
                    }
                    case LOOKUP -> {
                        LookupPage.builder().content("").prompt("").repo(null).build();
                    }
                    case CALCULATE -> {
                        CaculatePage.builder().content("").prompt("").repo(null).parser(null).build();
                    }
                }
                return null;
            }
        }
    }
}