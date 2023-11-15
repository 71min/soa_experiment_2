package com.example.restful.service.impl;

import com.example.restful.common.CommonResponse;
import com.example.restful.controller.EquipmentController;
import com.example.restful.controller.OperatorController;
import com.example.restful.domain.Equipment;
import com.example.restful.domain.Operator;
import com.example.restful.mapper.OperatorMapper;
import com.example.restful.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    OperatorMapper operatorMapper;
    @Override
    public CommonResponse<Object> getAllOperator() {
        List<Operator> equipmentList = operatorMapper.selectList(null);
        List<EntityModel<Operator>> operatorModels = new ArrayList<>();
        for (Operator operator : equipmentList) {
            EntityModel<Operator> operatorModel = EntityModel.of(operator);
            Link selfLink = WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(OperatorController.class).getOperatorById(operator.getOperatorId()))
                    .withSelfRel();
            operatorModel.add(selfLink);
            operatorModels.add(operatorModel);
        }
//        ResponseEntity<List<EntityModel<Equipment>>> res = new ResponseEntity<>(equipmentModels, HttpStatus.OK);
        return CommonResponse.createForSuccess("SUCCESS",operatorModels);
    }

    @Override
    public CommonResponse<Object> getOperatorById(Long id) {
        Operator operator = operatorMapper.selectById(id);
        if (operator != null) {
            EntityModel<Operator> operatorModel = EntityModel.of(operator);
            Link selfLink = WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(OperatorController.class).getOperatorById(id))
                    .withSelfRel();
            operatorModel.add(selfLink);
            return CommonResponse.createForSuccess("SUCCESS",operatorModel);
        } else {
            return CommonResponse.createForError();
        }
    }

    @Override
    public CommonResponse<Object> createOperator(Operator operator) {
        int is_create = operatorMapper.insert(operator);
        EntityModel<Operator> operatorModel = EntityModel.of(operator);
        Link selfLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(OperatorController.class).getOperatorById(operator.getOperatorId()))
                .withSelfRel();
        operatorModel.add(selfLink);
//        ResponseEntity<EntityModel<Equipment>> res = new ResponseEntity<>(equipmentModel,HttpStatus.OK);
        return CommonResponse.createForSuccess("SUCCESS",operatorModel);
    }

    @Override
    public CommonResponse<Object> updateOperator(Operator updatedOperator) {
        operatorMapper.updateById(updatedOperator);
        EntityModel<Operator> operatorModel = EntityModel.of(updatedOperator);
        Link selfLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(OperatorController.class).getOperatorById(updatedOperator.getOperatorId()))
                .withSelfRel();
        operatorModel.add(selfLink);
        return CommonResponse.createForSuccess("SUCCESS",operatorModel);
    }

    @Override
    public CommonResponse<Object> deleteOperator(Long id) {
        operatorMapper.deleteById(id);
        return CommonResponse.createForSuccess("SUCCESS","删除成功");
    }
}
