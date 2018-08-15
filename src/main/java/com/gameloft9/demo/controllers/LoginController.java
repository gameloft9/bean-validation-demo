package com.gameloft9.demo.controllers;

import com.gameloft9.demo.request.LoginInfoBean;
import com.gameloft9.demo.request.LoginInfoBean_2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


/**
 * controller中的bean校验示例
 * Created by gameloft9 on 2017/11/27.
 */
@Slf4j
@Controller
public class LoginController {

    public static final String USER_NAME="gameloft9";

    public static final String PWD = "123456";

    /**
     * 登录页面入口
     * */
    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(Model model, HttpServletResponse response){
        log.info("进入登录页面");
       return "login";
    }

    /**
     * 登录请求
     * 基于spring mvc中的validation
     * */
    @RequestMapping(value = "/login_1.do", method = RequestMethod.POST)
    public String login(Model model, @Validated LoginInfoBean loginInfoBean, BindingResult result){
        StringBuilder sb = new StringBuilder();
        if(null != result && result.hasErrors()){
            if (null != result.getFieldErrors()) {
                for (FieldError fe : result.getFieldErrors()) {
                    sb.append(fe.getDefaultMessage()).append(" ");
                }
            }
            model.addAttribute("errInfo",sb.toString());
            return "login";
        }

        if(USER_NAME.equalsIgnoreCase(loginInfoBean.getName())&&PWD.equals(loginInfoBean.getPwd())){
            model.addAttribute("name","雷尧");
            return "home";
        }

        log.error("用户名密码错误");
        model.addAttribute("errInfo","用户名或密码错误!");
        return "login";
    }

    /**
     * 登录请求
     * controller中的校验示例，基于hibernate的validation
     * */
    @RequestMapping(value = "/login_2.do", method = RequestMethod.POST)
    public String login_2(Model model, @Valid LoginInfoBean_2 loginInfoBean, BindingResult result){
        // spring mvc 中校验参数
        StringBuilder sb = new StringBuilder();
        if(null != result && result.hasErrors()){
            if (null != result.getFieldErrors()) {
                for (FieldError fe : result.getFieldErrors()) {
                    sb.append(fe.getDefaultMessage()).append(" ");
                }
            }
            model.addAttribute("errInfo",sb.toString());
            return "login";
        }

        if(USER_NAME.equalsIgnoreCase(loginInfoBean.getName_2())&&PWD.equals(loginInfoBean.getPwd_2())){
            model.addAttribute("name","gameloft9");
            return "home";
        }

        log.error("用户名密码错误");
        model.addAttribute("errInfo","用户名或密码错误!");
        return "login";
    }
}
