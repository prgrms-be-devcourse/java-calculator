package com.programmers.java;

import com.programmers.java.service.CalculateService;
import com.programmers.java.service.SearchService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        System.out.println("1.조회");
        System.out.println("2.계산");

        System.out.print("선택:");
        int option = Integer.parseInt(br.readLine());
        if(option ==1){
            SearchService searchService = new SearchService();
            searchService.searchResult();
        }else{
            br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();

            CalculateService calculateService = new CalculateService();

            String answer = calculateService.calculator(input);

            System.out.println(answer);
        }

    }

}