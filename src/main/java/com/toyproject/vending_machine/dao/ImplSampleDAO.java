package com.toyproject.vending_machine.dao;

import com.toyproject.vending_machine.dto.SampleDTO;
import com.toyproject.vending_machine.mapper.SampleMapper;
import com.toyproject.vending_machine.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImplSampleDAO implements SampleDAO {

    @Autowired
    SampleMapper sampleMapper;

    @Override
    public String getTime() {
        return sampleMapper.getTime();
    }
}
