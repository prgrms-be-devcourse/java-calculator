package com.programmers.engine;

import com.programmers.engine.caculator.Caculator;
import com.programmers.engine.repository.Repository;
import com.programmers.pages.*;

import java.util.HashMap;
import java.util.Map;

public class PageManager implements Runnable {
    Repository myRepo;
    Caculator caculator;
    Page currPage;
    Map<PageList,Page> pages= new HashMap<>();
    public PageManager(Repository repo, Caculator caculator,
                       Map<PageList,Page> pages, PageList startPage){
        this.myRepo = repo;
        this.caculator = caculator;
        this.pages = pages;
        this.currPage = this.pages.get(startPage);
    }

    @Override
    public void run() {
        while(true){
            currPage.run();
            if(currPage.getNextPage() ==PageList.NONE){
                break;
            }
            currPage = pages.get(currPage.getNextPage());

        }
    }
}
