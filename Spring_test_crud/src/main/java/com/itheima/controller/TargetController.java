package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/4/16 22:44
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
@RequestMapping("/user")
public class TargetController {
    @RequestMapping("/target")
    public  ModelAndView getTarget(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
