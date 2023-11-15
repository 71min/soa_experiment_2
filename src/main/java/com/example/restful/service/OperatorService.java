package com.example.restful.service;

import com.example.restful.common.CommonResponse;
import com.example.restful.domain.Equipment;
import com.example.restful.domain.Operator;

public interface OperatorService {
    public CommonResponse<Object> getAllOperator();

    public CommonResponse<Object> getOperatorById(Long id);

    public CommonResponse<Object> createOperator(Operator operator);

    public CommonResponse<Object> updateOperator(Operator updatedOperator);

    public CommonResponse<Object> deleteOperator(Long id);
}
