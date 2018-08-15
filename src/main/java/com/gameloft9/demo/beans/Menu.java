package com.gameloft9.demo.beans;

import com.gameloft9.demo.validation.group.MenuDeleteCheck;
import com.gameloft9.demo.validation.group.MenuUpdateCheck;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 基本分组，分组继承
 * Created by admin on 2018/8/14.
 */
@Data
public class Menu {

    @NotBlank(message = "id不能为空" ,groups = {MenuUpdateCheck.class, MenuDeleteCheck.class})
    private String id;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotBlank(message = "url不能为空")
    private String url;

    private String icon;
}
