package com.programmers.record;

import com.programmers.Controller;
import com.programmers.record.dto.RecordControllerResponseDto;
import com.programmers.repository.HistoryRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class RecordController implements Controller {
    private HistoryRepository historyRepository;

    public RecordControllerResponseDto loadRecordData(){
        return RecordControllerResponseDto.from(historyRepository.printData());
    }
}
