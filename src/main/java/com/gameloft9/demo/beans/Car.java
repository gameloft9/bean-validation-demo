package com.gameloft9.demo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by admin on 2018/8/14.
 */
@Data
@AllArgsConstructor
public class Car {

    @NotBlank(message = "制造商不能为空")
    private String manufacturer;

    @NotBlank(message = "车牌号不能为空")
    @Size(message = "车牌号必须{min}-{max}位，当前值是:${validatedValue}",min = 2, max = 14)
    private String licensePlate;

    @Min(message = "座位最少为{value}",value = 2)
    private int seatCount;

}
