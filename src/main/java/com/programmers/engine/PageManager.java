package com.programmers.engine;


import com.programmers.pages.*;
import java.util.Map;

public class PageManager implements Runnable {
    Page currPage;
    Map<PageList,Page> pages;
    public PageManager(Map<PageList,Page> pages, PageList startPage){
        this.pages = pages;
        this.currPage = this.pages.get(startPage);
    }

    @Override
    public void run() {
        while(true){
            currPage.render();
            if(currPage.getNextPage() == PageList.NONE){
                break;
            }
            currPage = pages.get(currPage.getNextPage());

        }
    }
}
