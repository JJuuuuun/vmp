package com.toyproject.vending_machine.controller;

import com.toyproject.vending_machine.dao.VendingMachineDAO;
import com.toyproject.vending_machine.dto.ResponseDTO;
import com.toyproject.vending_machine.dto.VendingMachineDTO;
import com.toyproject.vending_machine.vo.ConditionVO;
import com.toyproject.vending_machine.vo.ModifyVO;
import com.toyproject.vending_machine.vo.VendingMachineVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class VendingMachineController {

    @Autowired
    private VendingMachineDAO vendingMachineDAO;

    @GetMapping("/list")
    public ResponseEntity<Object> list() {
        return ResponseEntity.ok(ResponseDTO.responseForm("success", "200", vendingMachineDAO.getList()));
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody VendingMachineVO vendingMachineVO) {
        boolean isExist = vendingMachineDAO.register(vendingMachineVO);
        VendingMachineDTO registerMachine = VendingMachineDTO.from(vendingMachineVO);

        if (!isExist) {
            registerMachine.setMessage("register success");
            return ResponseEntity.ok(ResponseDTO.responseForm("success", "200", registerMachine));
        } else {
            registerMachine.setMessage("register fail. duplicated code or name");
            return ResponseEntity.badRequest().body(ResponseDTO.responseForm("fail", "404", registerMachine));
        }
    }

    @PostMapping("/search")
    public ResponseEntity<Object> findTarget(@RequestBody ConditionVO conditionVO) {
        List<VendingMachineVO> searchList = vendingMachineDAO.search(conditionVO);
        return ResponseEntity.ok(ResponseDTO.responseForm("success", "200", searchList));
    }

    @PutMapping("/modify")
    public ResponseEntity<Object> modify(@RequestBody ModifyVO modifyVO) {
        return ResponseEntity.ok(ResponseDTO.responseForm("success", "200", vendingMachineDAO.modify(modifyVO)));
    }
}
