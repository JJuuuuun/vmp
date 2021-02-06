package com.toyproject.vending_machine.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class LocationVO {
    private Integer x;
    private Integer y;

    private LocationVO(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public static LocationVO getInstance(LocationVO location) {
        if (Objects.isNull(location)) {
            return new LocationVO(0, 0);
        } else
            return new LocationVO(location.getX(), location.getY());
    }
}
