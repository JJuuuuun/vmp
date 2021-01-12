package com.toyproject.vending_machine.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {
    String getTime();
}
