package com.toyproject.vending_machine.controller;

import com.toyproject.vending_machine.dao.SampleDAO;
import com.toyproject.vending_machine.dto.SampleDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SampleController {


    //@controller -> @Service -> dao(@Repository) <-@Mapper/Mapper.xml-> dto / db
    @Autowired
    private SampleDAO sampleDAO;

    @GetMapping("/mapperTest")
    public String data() throws Exception {
        return sampleDAO.getTime();
    }
}
