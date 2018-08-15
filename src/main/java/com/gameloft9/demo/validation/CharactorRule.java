package com.gameloft9.demo.validation;

import lombok.Getter;

/**
 * Created by gameloft9 on 2018/8/15.
 */
public enum CharactorRule {
    Normal("[<>]+",false),
    Strong("^([\\u4e00-\\u9fa5]|[0-9]|[a-z]|[A-Z])*$",true);

    @Getter
    private String pattern; // 正表达式

    @Getter
    private boolean positive; // 是否正向匹配

    private CharactorRule(String pattern,boolean positive){
        this.pattern = pattern;
        this.positive = positive;
    }
}
