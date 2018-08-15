package com.gameloft9.demo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


import java.io.Serializable;

/**
 * Created by admin on 2018/8/13.
 */
@Data
public class LoginInfoBean_2 implements Serializable{

    @NotBlank(message = "姓名不能为空")
    private String name_2;

    @NotBlank(message = "密码不能为空")
    @Length(message = "密码长度{min}-{max}位",min = 6,max = 16)
    private String pwd_2;
}
