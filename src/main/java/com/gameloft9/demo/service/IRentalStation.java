package com.gameloft9.demo.service;

import com.gameloft9.demo.beans.Person;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by admin on 2018/8/14.
 */
public interface IRentalStation {

    public boolean rentCar( @NotNull @Valid Person customer,
                            @NotNull @Future Date startDate,
                            @Min(1) int durationInDays);
}
