package com.gameloft9.demo.request;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by gameloft9 on 2018/8/13.
 */
@Data
public class LoginInfoBean implements Serializable{

    @NotNull
    private String name;

    @NotNull
    @Size(min = 6,max = 16)
    private String pwd;
}
