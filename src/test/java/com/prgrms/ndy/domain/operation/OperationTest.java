package com.prgrms.ndy.domain.operation;

import com.prgrms.ndy.domain.Opcode;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    Offset<Double> OFFSET = Offset.offset(0.000_001);

    @Test
    void 더하면_더해진다(){
        double res = Opcode.ADD.apply(1.4, 3.0);
        assertThat(res).isCloseTo(4.4, OFFSET);
    }
}
