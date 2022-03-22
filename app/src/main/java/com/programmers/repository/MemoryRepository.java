package com.programmers.repository;

import com.programmers.entity.CaseData;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MemoryRepository implements CaseRepository {
    // 메모리 사용 저장소 store 생성
    private static Map<Long, CaseData> store = new LinkedHashMap<>();

    @Override
    public void save(CaseData caseData) {
        store.put(caseData.getId(), caseData);
    }

    @Override
    public CaseData findById(Long caseDataId) {
        return store.get(caseDataId);
    }

    @Override
    public void allStoreValue() {
        Iterator<Long> keys = store.keySet().iterator();
        while(keys.hasNext()){
            Long key = keys.next();
            System.out.println(store.get(key).getInputAndResultString());
        }
    }
}
