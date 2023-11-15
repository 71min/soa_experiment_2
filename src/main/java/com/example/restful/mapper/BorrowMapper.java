package com.example.restful.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.restful.domain.Borrow;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BorrowMapper extends BaseMapper<Borrow> {
}
