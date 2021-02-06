package com.toyproject.vending_machine.dto;

import com.toyproject.vending_machine.vo.ItemVO;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRegistryObj {
    @NonNull
    private String vmId;
    private ItemVO item;
}
