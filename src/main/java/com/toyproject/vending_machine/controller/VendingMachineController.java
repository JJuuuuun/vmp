package com.toyproject.vending_machine.controller;

import com.toyproject.vending_machine.dao.VendingMachineDAO;
import com.toyproject.vending_machine.dto.ItemRegistryObj;
import com.toyproject.vending_machine.dto.VmInfoObj;
import com.toyproject.vending_machine.dto.VmRegistryObj;
import com.toyproject.vending_machine.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/vm")
public class VendingMachineController {

    @Autowired
    private VendingMachineDAO vendingMachineDAO;

    private final Map<String, Object> dataMap = new HashMap<>();
    private final List<Object> dataList = new ArrayList<>();
    private void clearDataObject (Collection data) {
        data.clear();
    }

    @PostMapping("/registry")
    public ResponseEntity<ResponseDTO> registry(@RequestBody VmRegistryObj requestData) {
        if (!dataMap.isEmpty())
            clearDataObject((Collection) dataMap);

        if (vendingMachineDAO.vmRegistry(requestData)) {
            dataMap.put("vmId", requestData.getVmId());
            dataMap.put("vmName", requestData.getVmName());

            return ResponseEntity.ok(ResponseDTO.responseForm("success", "200", dataMap));
        }
        return ResponseEntity.ok(ResponseDTO.responseForm("bad request", "400", null));
    }

    @PostMapping("/registry/item")
    public ResponseEntity<ResponseDTO> itemRegistry(@RequestBody ItemRegistryObj requestData) {
        if (!dataMap.isEmpty())
            clearDataObject((Collection) dataMap);

        if (vendingMachineDAO.itemRegistry(requestData)) {
            dataMap.put("vmItemList", vendingMachineDAO.getVmHasAllItems(requestData.getVmId()));
            return ResponseEntity.ok(ResponseDTO.responseForm("success", "200", dataMap));
        }
        return ResponseEntity.ok(ResponseDTO.responseForm("bad request", "400",  null));
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDTO> showList() {
        if (!dataList.isEmpty())
            clearDataObject(dataList);

        List<String> vmIdLists = vendingMachineDAO.getVmIdLists();
        for (String vmId : vmIdLists) {
            dataList.add(vendingMachineDAO.getVmInfo(vmId));
        }
        if (!dataList.isEmpty())
            return ResponseEntity.ok(ResponseDTO.responseForm("success", "200", dataList));

        return ResponseEntity.ok(ResponseDTO.responseForm("bad request", "400", null));
    }

    @GetMapping("/info")
    public ResponseEntity<ResponseDTO> info(@RequestParam("vmId") String vmId) {
        if (!dataMap.isEmpty())
            clearDataObject((Collection) dataMap);

        VmInfoObj infoObj = vendingMachineDAO.getVmInfo(vmId);
        if (!Objects.isNull(infoObj)) {
            dataMap.put("machine", infoObj);
            return ResponseEntity.ok(ResponseDTO.responseForm("success", "200", dataMap));
        }

        return ResponseEntity.ok(ResponseDTO.responseForm("bad request", "400", null));
    }

}
