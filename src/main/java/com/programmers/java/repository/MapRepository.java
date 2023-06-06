package com.programmers.java.repository;


import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


public class MapRepository {

    static Map<Integer,String> map = new TreeMap<>();

    public void save(String result){
        int size = map.size();

        map.put(size+1,result);

    }

    public static void findAll() throws IOException {



        if(map.size()==0) return;

        for(Integer key : map.keySet()){
            System.out.println(map.get(key)+"/n");
        }

    }



}

