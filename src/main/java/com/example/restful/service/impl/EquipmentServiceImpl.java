package com.example.restful.service.impl;

import com.example.restful.common.CommonResponse;
import com.example.restful.controller.EquipmentController;
import com.example.restful.domain.Equipment;
import com.example.restful.mapper.EquipmentMapper;
import com.example.restful.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    EquipmentMapper equipmentMapper;
    @Override
    public CommonResponse<Object> getAllEquipment() {
        List<Equipment> equipmentList = equipmentMapper.selectList(null);
        List<EntityModel<Equipment>> equipmentModels = new ArrayList<>();
        for (Equipment equipment : equipmentList) {
            EntityModel<Equipment> equipmentModel = EntityModel.of(equipment);
            Link selfLink = WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(EquipmentController.class).getEquipmentById(equipment.getEquipmentId()))
                    .withSelfRel();
            equipmentModel.add(selfLink);
            equipmentModels.add(equipmentModel);
        }
//        ResponseEntity<List<EntityModel<Equipment>>> res = new ResponseEntity<>(equipmentModels, HttpStatus.OK);
        return CommonResponse.createForSuccess("SUCCESS",equipmentModels);
    }

    @Override
    public CommonResponse<Object> getEquipmentById(Long id) {
        Equipment equipment = equipmentMapper.selectById(id);
        if (equipment != null) {
            EntityModel<Equipment> equipmentModel = EntityModel.of(equipment);
            Link selfLink = WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(EquipmentController.class).getEquipmentById(id))
                    .withSelfRel();
            equipmentModel.add(selfLink);
            return CommonResponse.createForSuccess("SUCCESS",equipmentModel);
        } else {
            return CommonResponse.createForError();
        }
    }


    @Override
    public CommonResponse<Object> createEquipment(Equipment equipment) {
        int is_create = equipmentMapper.insert(equipment);
        EntityModel<Equipment> equipmentModel = EntityModel.of(equipment);
        Link selfLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(EquipmentController.class).getEquipmentById(equipment.getEquipmentId()))
                        .withSelfRel();
        equipmentModel.add(selfLink);
//        ResponseEntity<EntityModel<Equipment>> res = new ResponseEntity<>(equipmentModel,HttpStatus.OK);
        return CommonResponse.createForSuccess("SUCCESS",equipmentModel);
    }

    @Override
    public CommonResponse<Object> updateEquipment(Equipment updatedEquipment) {
        equipmentMapper.updateById(updatedEquipment);
        EntityModel<Equipment> equipmentModel = EntityModel.of(updatedEquipment);
        Link selfLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(EquipmentController.class).getEquipmentById(updatedEquipment.getEquipmentId()))
                .withSelfRel();
        equipmentModel.add(selfLink);
        return CommonResponse.createForSuccess("SUCCESS",equipmentModel);
    }

    @Override
    public CommonResponse<Object> deleteEquipment(Long id) {
        equipmentMapper.deleteById(id);
        return CommonResponse.createForSuccess("SUCCESS","删除成功");
    }

}
