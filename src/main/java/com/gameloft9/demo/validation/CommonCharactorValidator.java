package com.gameloft9.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Created by gameloft9 on 2018/8/14.
 */
public class CommonCharactorValidator implements ConstraintValidator<CommonCharactor, CharSequence> {

    private Pattern pattern;

    private CharactorRule validateRule;

    public CommonCharactorValidator(){}

    /**
     * 初始化，你可以获取注解上的内容并进行处理
     * */
    public void initialize(CommonCharactor commonCharactor) {
         validateRule = commonCharactor.charactorRule();
         pattern = Pattern.compile(commonCharactor.charactorRule().getPattern());
    }

    /**
     * 覆写验证逻辑
     * */
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        return validateRule.isPositive()?pattern.matcher(charSequence.toString()).matches():!pattern.matcher(charSequence.toString()).matches();
    }
}
