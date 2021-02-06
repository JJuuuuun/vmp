package com.toyproject.vending_machine.dto;


import com.toyproject.vending_machine.vo.LocationVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VmRegistryObj {
    @NonNull
    private String vmId;
    @NonNull
    private String vmName;
    private LocationVO vmLocations;
}
