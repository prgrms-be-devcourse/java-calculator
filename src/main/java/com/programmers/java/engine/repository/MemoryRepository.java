package com.programmers.java.engine.repository;

public interface MemoryRepository {

   void save(String formula, Long result) ;

   void find();

   int size();
}
