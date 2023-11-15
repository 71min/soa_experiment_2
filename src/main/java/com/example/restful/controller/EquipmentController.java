package com.example.restful.controller;
import com.example.restful.common.CommonResponse;
import com.example.restful.domain.Equipment;
import com.example.restful.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/equipments")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;
    //CommonResponse<Object>
    @GetMapping
    public CommonResponse<Object> getAllEquipment() {
        return equipmentService.getAllEquipment();
    }

    @GetMapping("/{id}")
    public CommonResponse<Object> getEquipmentById(@PathVariable Long id) {
        return equipmentService.getEquipmentById(id);
    }

    @PostMapping
    public CommonResponse<Object> createEquipment(@RequestBody Equipment equipment) {
        return equipmentService.createEquipment(equipment);
    }

    @PutMapping()
    public CommonResponse<Object> updateEquipment(@RequestBody Equipment updatedEquipment) {
        return equipmentService.updateEquipment(updatedEquipment);
    }

    @DeleteMapping("/{id}")
    public CommonResponse<Object> deleteEquipment(@PathVariable Long id) {
        return equipmentService.deleteEquipment(id);
    }
}
