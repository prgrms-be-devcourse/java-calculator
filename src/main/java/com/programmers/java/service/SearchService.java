package com.programmers.java.service;

import com.programmers.java.repository.MapRepository;

import java.io.IOException;

public class SearchService {

    public void searchResult() throws IOException{
        MapRepository.findAll();

    }
}
