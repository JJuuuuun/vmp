package com.toyproject.vending_machine.dao;

import com.toyproject.vending_machine.dto.ItemRegistryObj;
import com.toyproject.vending_machine.dto.VmInfoObj;
import com.toyproject.vending_machine.dto.VmRegistryObj;
import com.toyproject.vending_machine.mapper.VmMapper;
import com.toyproject.vending_machine.vo.ItemVO;
import com.toyproject.vending_machine.vo.LocationVO;
import com.toyproject.vending_machine.vo.VendingMachineVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ImplVendingMachineDAO implements VendingMachineDAO {

    @Autowired
    VmMapper vmMapper;

    @Override
    public boolean vmRegistry(VmRegistryObj vo) {
        try {
            vmMapper.registryVendingMachine(VendingMachineVO.getInstance(vo.getVmId(), vo.getVmName()));
            vmMapper.registryLocation(vo.getVmId(), LocationVO.getInstance(vo.getVmLocations()));

            return true;
        } catch (Exception e) {
            System.out.println("Vending Machine registry fail : this message is in ImplVendingMachineDAO");
            e.printStackTrace();
            return false;
        }
   }

    @Override
    public boolean itemRegistry(ItemRegistryObj vo) {
        try {
//            convert ?? vo.getItem().getItemExpireDate();
            vmMapper.registryItem(vo.getVmId(), vo.getItem());

            return true;
        } catch (Exception e) {
            System.out.println("Item registry fail : this message is in ImplVendingMachineDAO");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ItemVO> getVmHasAllItems(String vmId) {
        return vmMapper.getVmHasAllItems(vmId);
    }

    @Override
    public VmInfoObj getVmInfo(String vmId) {
        VmInfoObj infoObj = new VmInfoObj();
        infoObj.setProperties(
                vmMapper.getVmBasicInfo(vmId)
                , vmMapper.getVmHasAllItems(vmId)
                , vmMapper.getVmLocation(vmId)
        );

        return infoObj;
    }

    @Override
    public List<String> getVmIdLists() {
        return vmMapper.getVmIdLists();
    }

    /*
    @Override
    public boolean register(VendingMachineVO vo) {
        //  code    name
        //   o       x  > no
        //   x       o  > no
        //   o       o  > no
        //   x       x  > yes
        if (isExist(vo)) {
            machines.add(vo);
            return false;
        } else
            return true;
    }

    private boolean isExist(VendingMachineVO vo) {
        boolean isCodeExist = machines.stream()
                .anyMatch(each -> each.getCode().equals(vo.getCode()));

        boolean isNameExist = machines.stream()
                .anyMatch(each -> each.getName().equals(vo.getName()));

        return !(isCodeExist || isNameExist);
    }

    @Override
    public List<VendingMachineVO> search(ConditionVO vo) {
        List<VendingMachineVO> list;

        list = machines.stream()
                .filter(each -> vo.getCondition().equals(each.getName()))
                .collect(Collectors.toList());

        list.addAll(machines.stream()
                .filter(each -> vo.getCondition().equals(String.valueOf(each.getCode())))
                .collect(Collectors.toList()));

        list.sort((o1, o2) -> {
            long code1 = o1.getCode();
            long code2 = o2.getCode();

            return Long.compare(code1, code2);
        });

        return list;
    }

    @Override
    public Map<String, VendingMachineDTO> modify(ModifyVO vo) {
        Map<String, VendingMachineDTO> result = new HashMap<>();

        VendingMachineVO modifyTarget = findTarget(vo);
        result.put("before", VendingMachineDTO.from(modifyTarget));
        result.put("after", VendingMachineDTO.from(updateTarget(modifyTarget, vo)));

        return result;
    }

    private VendingMachineVO findTarget(ModifyVO vo) {
        VendingMachineVO vendingMachineVO = null, tempVO;

        for (VendingMachineVO machine : machines) {
            tempVO = machine;
            if (String.valueOf(tempVO.getCode()).equals(vo.getTargetObj())) {
                vendingMachineVO = tempVO;
                break;
            }
        }

        if (Objects.isNull(vendingMachineVO)) {
            for (VendingMachineVO machine : machines) {
                tempVO = machine;
                if (tempVO.getName().equals(vo.getTargetObj())) {
                    vendingMachineVO = tempVO;
                    break;
                }
            }
        }

        return vendingMachineVO;
    }

    private VendingMachineVO updateTarget(VendingMachineVO vendingMachineVO, ModifyVO modifyVO) {
        if ("code".equals(modifyVO.getProperty()))
            vendingMachineVO.setCode(Long.valueOf(modifyVO.getValue()));
        else if ("name".equals(modifyVO.getProperty()))
            vendingMachineVO.setName(modifyVO.getValue());

        return vendingMachineVO;
    }*/
}
