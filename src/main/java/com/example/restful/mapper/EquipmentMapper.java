package com.example.restful.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.restful.domain.Equipment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EquipmentMapper extends BaseMapper<Equipment> {
}
