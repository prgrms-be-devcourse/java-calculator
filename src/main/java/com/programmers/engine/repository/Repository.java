package com.programmers.engine.repository;

public interface Repository {
    default public void loadData(){
        //아무것도 하지 않는다.
    };
    public String getData();
    public void addData(String data);
    default public void saveData(){
        //아무것도 하지 않는다.
    };
}
