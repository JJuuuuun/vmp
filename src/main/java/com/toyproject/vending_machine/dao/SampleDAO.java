package com.toyproject.vending_machine.dao;

import com.toyproject.vending_machine.dto.SampleDTO;
import com.toyproject.vending_machine.vo.TestVO;

import java.util.List;

public interface SampleDAO {
    String getTime();

    void insertTestData(TestVO vo);
}
