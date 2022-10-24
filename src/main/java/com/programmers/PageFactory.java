package com.programmers;

import com.programmers.pages.*;

public class PageFactory {
    public static Page createPage(PageList type){
        switch (type){
            case START -> {
                return new StartPage("1.조회\n2.계산","선택 : ",PageList.NONE);
            }
            case LOOKUP -> new LookupPage(null,null,PageList.START);
            case CALCULATE -> new CaculatePage(null,"",PageList.START);
        }
        return null;
    }
}
