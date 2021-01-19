package com.toyproject.vending_machine.mapper;

import com.toyproject.vending_machine.vo.TestVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {
    String getTime();

    void insertTestData(TestVO vo);
}
