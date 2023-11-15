package com.example.restful.controller;

import com.example.restful.common.CommonResponse;
import com.example.restful.domain.Equipment;
import com.example.restful.domain.Operator;
import com.example.restful.service.EquipmentService;
import com.example.restful.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/operators")
public class OperatorController {

    @Autowired
    OperatorService operatorService;

    @GetMapping
    public CommonResponse<Object> getAllOperator() {
        return operatorService.getAllOperator();
    }

    @GetMapping("/{id}")
    public CommonResponse<Object> getOperatorById(@PathVariable Long id) {
        return operatorService.getOperatorById(id);
    }

    @PostMapping
    public CommonResponse<Object> createOperator(@RequestBody Operator operator) {
        return operatorService.createOperator(operator);
    }

    @PutMapping()
    public CommonResponse<Object> updateOperator(@RequestBody Operator updatedOperator ) {
        return operatorService.updateOperator(updatedOperator);
    }

    @DeleteMapping("/{id}")
    public CommonResponse<Object> deleteOperator(@PathVariable Long id) {
        return operatorService.deleteOperator(id);
    }
}
