package org.programmers.repository;

import org.programmers.entity.ResultModel;

import java.util.Map;

public interface Repository{

    Map<Long, ResultModel> findAll();

    ResultModel save(ResultModel entity);
}
