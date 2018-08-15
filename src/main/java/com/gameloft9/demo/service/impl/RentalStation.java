package com.gameloft9.demo.service.impl;

import com.gameloft9.demo.beans.Person;
import com.gameloft9.demo.service.IRentalStation;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by admin on 2018/8/14.
 */
@Slf4j
public class RentalStation implements IRentalStation {

    @AssertFalse
    public boolean rentCar(
            @NotNull @Valid Person customer,
            @NotNull @Future Date startDate,
            @Min(1) int durationInDays) {

        log.info("{}在{}租车成功！租期{}",customer.getName(),startDate,durationInDays);
        return true;
    }
}
