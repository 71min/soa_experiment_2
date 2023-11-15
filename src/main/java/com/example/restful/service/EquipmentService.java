package com.example.restful.service;

import com.example.restful.common.CommonResponse;
import com.example.restful.domain.Equipment;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EquipmentService {

    public CommonResponse<Object> getAllEquipment();

    public CommonResponse<Object> getEquipmentById(Long id);

    public CommonResponse<Object> createEquipment(Equipment equipment);

    public CommonResponse<Object> updateEquipment(Equipment updatedEquipment);

    public CommonResponse<Object> deleteEquipment(Long id);
}
