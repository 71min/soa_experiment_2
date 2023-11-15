package com.example.restful.service.impl;

import com.example.restful.common.BaseService;
import com.example.restful.common.CommonResponse;
import com.example.restful.controller.BorrowController;
import com.example.restful.controller.EquipmentController;
import com.example.restful.controller.OperatorController;
import com.example.restful.domain.Borrow;
import com.example.restful.domain.Equipment;
import com.example.restful.domain.Operator;
import com.example.restful.mapper.BorrowMapper;
import com.example.restful.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    BorrowMapper borrowMapper;
    @Override
    public CommonResponse<Object> getAllBorrow() {
        List<Borrow> borrowList = borrowMapper.selectList(null);
        List<EntityModel<Borrow>> borrowModels = new ArrayList<>();
        for (Borrow borrow : borrowList) {
            EntityModel<Borrow> borrowModel = EntityModel.of(borrow);
            Link selfLink = WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(BorrowController.class).getBorrowById(borrow.getBorrowId()))
                    .withSelfRel();
            Link equipmentLink = WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(EquipmentController.class).getEquipmentById(borrow.getEquipmentId()))
                    .withRel("equipment");
            Link operatorLink = WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(OperatorController.class).getOperatorById(borrow.getOperatorId()))
                    .withRel("operator");
            borrowModel.add(selfLink,equipmentLink,operatorLink);

            //最终添加
            borrowModels.add(borrowModel);
        }
//        ResponseEntity<List<EntityModel<Equipment>>> res = new ResponseEntity<>(equipmentModels, HttpStatus.OK);
        return CommonResponse.createForSuccess("SUCCESS",borrowModels);
    }

    @Override
    public CommonResponse<Object> getBorrowById(Long id) {
        Borrow borrow = borrowMapper.selectById(id);
        if (borrow != null) {
            EntityModel<Borrow> borrowModel = EntityModel.of(borrow);
            Link selfLink = WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(BorrowController.class).getBorrowById(borrow.getBorrowId()))
                    .withSelfRel();
            Link equipmentLink = WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(EquipmentController.class).getEquipmentById(borrow.getEquipmentId()))
                    .withRel("equipment");
            Link operatorLink = WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(OperatorController.class).getOperatorById(borrow.getOperatorId()))
                    .withRel("operator");
            borrowModel.add(selfLink,equipmentLink,operatorLink);
            return CommonResponse.createForSuccess("SUCCESS",borrowModel);
        } else {
            return CommonResponse.createForError();
        }
    }

    @Override
    public CommonResponse<Object> createBorrow(Borrow borrow) {
        int is_create = borrowMapper.insert(borrow);
        EntityModel<Borrow> borrowModel = EntityModel.of(borrow);
        Link selfLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(BorrowController.class).getBorrowById(borrow.getBorrowId()))
                .withSelfRel();
        Link equipmentLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(EquipmentController.class).getEquipmentById(borrow.getEquipmentId()))
                .withRel("equipment");
        Link operatorLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(OperatorController.class).getOperatorById(borrow.getOperatorId()))
                .withRel("operator");
        borrowModel.add(selfLink,equipmentLink,operatorLink);
        return CommonResponse.createForSuccess("SUCCESS",borrowModel);
    }

    @Override
    public CommonResponse<Object> updateBorrow(Borrow updatedBorrow) {
        borrowMapper.updateById(updatedBorrow);
        EntityModel<Borrow> borrowModel = EntityModel.of(updatedBorrow);
        Link selfLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(BorrowController.class).getBorrowById(updatedBorrow.getBorrowId()))
                .withSelfRel();
        Link equipmentLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(EquipmentController.class).getEquipmentById(updatedBorrow.getEquipmentId()))
                .withRel("equipment");
        Link operatorLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(OperatorController.class).getOperatorById(updatedBorrow.getOperatorId()))
                .withRel("operator");
        borrowModel.add(selfLink,equipmentLink,operatorLink);
        return CommonResponse.createForSuccess("SUCCESS",borrowModel);
    }

    @Override
    public CommonResponse<Object> deleteBorrow(Long id) {
        borrowMapper.deleteById(id);
        return CommonResponse.createForSuccess("SUCCESS","删除成功");
    }
}
