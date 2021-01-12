package com.toyproject.vending_machine.dao;

import com.toyproject.vending_machine.dto.VendingMachineDTO;
import com.toyproject.vending_machine.vo.ConditionVO;
import com.toyproject.vending_machine.vo.ModifyVO;
import com.toyproject.vending_machine.vo.VendingMachineVO;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ImplVendingMachineDAO implements VendingMachineDAO {

    private List<VendingMachineVO> machines;

    public ImplVendingMachineDAO() {
        machines = new ArrayList<>();
    }

    @Override
    public List<VendingMachineVO> getList() {
        machines.sort(((o1, o2) -> {
            long code1 = o1.getCode();
            long code2 = o2.getCode();

            if (code1 > code2) return 1;
            else if (code1 == code2) return 0;
            else return -1;
        }));
        return machines;
    }

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

        return !(isCodeExist && isNameExist);
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

            if (code1 > code2) return 1;
            else if (code1 == code2) return 0;
            else return -1;
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
        VendingMachineVO vendingMachineVO = null, tempVO = null;

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
    }
}
