package com.programmers.project;

import com.programmers.project.repository.DataRepository;
import com.programmers.project.repository.VolatilityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    DataRepository repository = new VolatilityRepository();

    @Test
    void 연산저장하기(){
        String str = "13 * 4 + 3";

        Assertions.assertFalse(repository.getAllRecords().contains(str));
        repository.add("13 * 4 + 3");
        Assertions.assertTrue(repository.getAllRecords().contains(str));

    }
}
