package com.programmers;

import com.programmers.pages.Page;
import com.programmers.pages.PageList;

public class App {
    public static void main(String[] args) {
        Page currPage = PageFactory.createPage(PageList.START);
        currPage.run();

    }
}