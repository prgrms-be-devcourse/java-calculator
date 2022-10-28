package com.programmers.repository;

import java.util.Collection;

public interface HistoryRepository {

    Collection<String> readData();

    public String printData();

    public void addData(String data);

}
