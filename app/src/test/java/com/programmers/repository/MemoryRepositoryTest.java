package com.programmers.repository;

import com.programmers.entity.CaseData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class MemoryRepositoryTest {
    CaseRepository caseRepository = new MemoryRepository();
    
    @Test
    @DisplayName("CaseData Repository 에 저장후 저장되는지 비교")
    public void save () throws Exception{
        // given
        CaseData caseData = new CaseData(1L, "1 + 2", 3d);
        // when
        caseRepository.save(caseData);
        
        // then
        Assertions.assertEquals(caseData, caseRepository.findById(1L));
        
    }

}