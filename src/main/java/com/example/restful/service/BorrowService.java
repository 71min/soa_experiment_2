package com.example.restful.service;

import com.example.restful.common.CommonResponse;
import com.example.restful.domain.Borrow;

public interface BorrowService {
    public CommonResponse<Object> getAllBorrow();

    public CommonResponse<Object> getBorrowById(Long id);

    public CommonResponse<Object> createBorrow(Borrow borrow);

    public CommonResponse<Object> updateBorrow(Borrow updatedBorrow);

    public CommonResponse<Object> deleteBorrow(Long id);
}
