package com.toyproject.vending_machine.vo;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemVO {

    @NonNull
    private String itemId;
    @NonNull
    private String itemName;
    private Integer itemQuantity;
    private Integer itemVolume;
    private String itemVolumeUnit;
    private String itemExpireDate;

}
