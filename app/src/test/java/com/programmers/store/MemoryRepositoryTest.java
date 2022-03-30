package com.programmers.store;

import com.programmers.item.CaseData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class MemoryRepositoryTest {
    CaseStore caseStore = new MemoryStore();
    
    @Test
    @DisplayName("CaseData Repository 에 저장후 저장되는지 비교")
    public void save () throws Exception{
        // given
        CaseData caseData = new CaseData(1L, "1 + 2", 3d);
        // when
        caseStore.save(caseData);
        
        // then
        Assertions.assertEquals(caseData, caseStore.findById(1L));
        
    }

}