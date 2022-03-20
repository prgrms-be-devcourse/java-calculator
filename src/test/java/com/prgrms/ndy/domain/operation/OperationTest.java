package com.prgrms.ndy.domain.operation;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    Offset<Double> OFFSET = Offset.offset(0.000_001);

    @Test
    void 더하면_더해진다(){
        Operation add = new Addition();
        double res = add.calc(1.4, 3.0);
        assertThat(res).isCloseTo(4.4, OFFSET);
    }
}
