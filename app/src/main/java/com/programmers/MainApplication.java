package com.programmers;

import com.programmers.service.MainService;


public class MainApplication {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MainService mainService = appConfig.mainService();
        mainService.playCalculate();
    }
}
