package com.example.restful.controller;

import com.example.restful.common.BaseService;
import com.example.restful.common.CommonResponse;
import com.example.restful.domain.Borrow;
import com.example.restful.service.BorrowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/borrows")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @GetMapping
    public CommonResponse<Object> getAllBorrow() {
        return borrowService.getAllBorrow();
    }

    @GetMapping("/{id}")
    public CommonResponse<Object> getBorrowById(@PathVariable Long id) {
        return borrowService.getBorrowById(id);
    }

    @PostMapping
    public CommonResponse<Object> createBorrow(@RequestBody Borrow borrow) {
        return borrowService.createBorrow(borrow);
    }

    @PutMapping()
    public CommonResponse<Object> updateBorrow(@RequestBody Borrow updatedBorrow) {
        return borrowService.updateBorrow(updatedBorrow);
    }

    @DeleteMapping("/{id}")
    public CommonResponse<Object> deleteBorrow(@PathVariable Long id) {
        return borrowService.deleteBorrow(id);
    }
}
