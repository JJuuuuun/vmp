package com.toyproject.vending_machine.dao;

import com.toyproject.vending_machine.dto.VendingMachineDTO;
import com.toyproject.vending_machine.vo.ConditionVO;
import com.toyproject.vending_machine.vo.ModifyVO;
import com.toyproject.vending_machine.vo.VendingMachineVO;

import java.util.List;
import java.util.Map;

public interface VendingMachineDAO {

    List<VendingMachineVO> getList();

    boolean register(VendingMachineVO vo);

    List<VendingMachineVO> search(ConditionVO vo);

    Map<String, VendingMachineDTO> modify(ModifyVO vo);

}
