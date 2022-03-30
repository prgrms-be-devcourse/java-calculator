package com.programmers.store;

import com.programmers.item.CaseData;

public interface CaseStore {

    void save(CaseData caseData);

    CaseData findById(Long memberId);

    void allStoreValue();
}
