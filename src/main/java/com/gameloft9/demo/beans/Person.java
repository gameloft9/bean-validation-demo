package com.gameloft9.demo.beans;

import com.gameloft9.demo.validation.CharactorRule;
import com.gameloft9.demo.validation.CommonCharactor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by admin on 2018/8/14.
 */
@Data
@AllArgsConstructor
public class Person {

    @NotBlank(message = "姓名不能为空")
    @CommonCharactor(message = "姓名只能由汉字，数字，字母组成",charactorRule = CharactorRule.Normal)
    private String name;

}
