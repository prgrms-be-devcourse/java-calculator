package com.programmers.project.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface DataRepository {
    List<String> getAllRecords();
    void add(String str);

}
