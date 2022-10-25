package com.programmers.engine.repository;

import java.util.Collection;
import java.util.List;

public interface Repository {
    default public void loadData(){
        //아무것도 하지 않는다.
    };
    public Collection<String> readData();
    public String printData();
    public void addData(String data);
    default public void saveData(){
        //아무것도 하지 않는다.
    };
}
