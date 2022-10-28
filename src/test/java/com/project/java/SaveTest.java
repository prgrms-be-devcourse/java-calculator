package com.project.java;

import com.project.java.engine.data.SaveFormat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveTest {

    @Test
    public void saveTest() throws Exception {
        //given
        List<SaveFormat> memoryRepository = new ArrayList<>();
        int idx = 0;
        Map<Integer, List<String>> expression = new HashMap<>();
        expression.put(13, List.of("4", "+", "9"));
        // when
        for (Integer key : expression.keySet()) {
            StringBuffer sb = new StringBuffer();
            for (String numOper : expression.get(key)) {
                sb.append(numOper).append(" ");
            }
            sb.append("= ").append(key);
            memoryRepository.add(new SaveFormat(++idx, sb.toString()));
        }
        //then
        System.out.println(memoryRepository.get(0));
    }
}
