package com.toyproject.vending_machine.vo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendingMachineVO {

    @NonNull
    private String vmName;
    @NonNull
    private String vmId;
    private String vmStatus;
    private Integer vmChanges;

    private VendingMachineVO(String vmId, String vmName) {
        this.vmId = vmId;
        this.vmName = vmName;

        this.vmStatus = "usable";
        this.vmChanges = 10000;
    }

    public static VendingMachineVO getInstance(String vmId, String vmName) {
        return new VendingMachineVO(vmId, vmName);
    }
}
