package com.toyproject.vending_machine.dao;


import com.toyproject.vending_machine.dto.ItemRegistryObj;
import com.toyproject.vending_machine.dto.VmInfoObj;
import com.toyproject.vending_machine.dto.VmRegistryObj;
import com.toyproject.vending_machine.vo.ItemVO;
import com.toyproject.vending_machine.vo.VendingMachineVO;

import java.util.List;

public interface VendingMachineDAO {
    /**
     * 자판기 등록하기
     * 아이디와 이름은 중복될 수 없다.
     * 위치는 nullable 이다.
     * @param vo -> VmRegistryObj
     * @return boolean
     */
    boolean vmRegistry(VmRegistryObj vo);

    /**
     * 자판기가 가지는 아이템 등록하기
     * @param vo -> ItemRegistryObj
     * @return boolean
     */
    boolean itemRegistry(ItemRegistryObj vo);

    /**
     * 검색하기
     * @param vmId
     * 아이디를 검색 조건으로 사용
     *
     * @return VendingMachineVO
     */
    VmInfoObj getVmInfo(String vmId);

    /**
     * 리스트로 모두 출력하기위한 id를 얻는다.
     * @return List<VendingMachineVO>
     */
    List<String> getVmIdLists();

    /**
     * 자판기가 갖고있는 모든 아이템 얻기
     * @param vmId
     * 아이디를 검색 조건으로 사용
     * @return List<ItemVo>
     */
    List<ItemVO> getVmHasAllItems(String vmId);
}
