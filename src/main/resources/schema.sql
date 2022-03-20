DROP TABLE IF EXISTS calculation;

-- 계산 데이터이다.
CREATE TABLE calculation
(
    seq           bigint            NOT NULL AUTO_INCREMENT,              -- 계산 PK
    expression    varchar(50)       NOT NULL,                             -- 계산 식
    result        NUMERIC(20, 6)    NOT NULL,                             -- 결과 값
    create_at     datetime          NOT NULL DEFAULT CURRENT_TIMESTAMP(), -- 생성일시
    PRIMARY KEY (seq)
);