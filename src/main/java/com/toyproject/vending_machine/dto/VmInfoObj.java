package com.toyproject.vending_machine.dto;

import com.toyproject.vending_machine.vo.ItemVO;
import com.toyproject.vending_machine.vo.LocationVO;
import com.toyproject.vending_machine.vo.VendingMachineVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VmInfoObj {

    private String vmId;
    private String vmName;
    private String vmStatus;
    private Integer vmChanges;
    private List<ItemVO> vmItemList;
    private LocationVO vmLocation;

    public void setProperties(VendingMachineVO vmBasicInfo, List<ItemVO> itemLists, LocationVO location) {
        this.vmId = vmBasicInfo.getVmId();
        this.vmName = vmBasicInfo.getVmName();
        this.vmStatus = vmBasicInfo.getVmStatus();
        this.vmChanges = vmBasicInfo.getVmChanges();
        this.vmItemList = itemLists;
        this.vmLocation = location;
    }
}
