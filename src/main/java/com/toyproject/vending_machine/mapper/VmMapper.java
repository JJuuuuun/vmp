package com.toyproject.vending_machine.mapper;

import com.toyproject.vending_machine.vo.ItemVO;
import com.toyproject.vending_machine.vo.LocationVO;
import com.toyproject.vending_machine.vo.VendingMachineVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VmMapper {
    void registryVendingMachine(VendingMachineVO vo);

    void registryLocation(String vmId, LocationVO vo);

    void registryItem(String vmId, ItemVO vo);

    List<ItemVO> getVmHasAllItems(String vmId);

    VendingMachineVO getVmBasicInfo(String vmId);

    LocationVO getVmLocation(String vmId);

    List<String> getVmIdLists();

    List<VendingMachineVO> showAllVmList();
}
