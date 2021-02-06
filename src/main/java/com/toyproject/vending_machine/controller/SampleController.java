package com.toyproject.vending_machine.controller;

import com.toyproject.vending_machine.dao.SampleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


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
