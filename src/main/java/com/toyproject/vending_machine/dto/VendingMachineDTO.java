package com.toyproject.vending_machine.dto;

import com.toyproject.vending_machine.vo.VendingMachineVO;
import lombok.Getter;
import lombok.Setter;

public class VendingMachineDTO {

    @Setter
    @Getter
    private String message;
    @Getter
    private final String name;
    @Getter
    private final Long code;

    private VendingMachineDTO(VendingMachineVO vendingMachineVO) {
        this.name = vendingMachineVO.getName();
        this.code = vendingMachineVO.getCode();
        message = "machine was made successfully";
    }

    public static VendingMachineDTO from(VendingMachineVO vendingMachineVO) {
        return new VendingMachineDTO(vendingMachineVO);
    }
}
