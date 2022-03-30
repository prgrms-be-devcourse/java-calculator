package com.programmers.repository;

import com.programmers.entity.CaseData;

public interface CaseRepository {

    void save(CaseData caseData);

    CaseData findById(Long memberId);

    void allStoreValue();
}
