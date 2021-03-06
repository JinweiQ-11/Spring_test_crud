package com.itheima.controller;

import com.itheima.dao.imp.RoleDaoService;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/4/16 17:11
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
@RequestMapping("/user")
public class UerController {
    @Autowired
    private  UserService userService;

    @Autowired
    private RoleDaoService roleDaoService;

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.list();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;

    }
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleDaoService.findAll();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(User user,Long [] roleIds){
        userService.save(user,roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/del/{userId}")
    public String del(@PathVariable("userId") Long userId){
        userService.del(userId);
        return "redirect:/user/list";
    }
    @RequestMapping(value = "/login")
    public String login(String username, String password, HttpSession httpSession){
        User user = userService.login(username,password);
        if (user!=null) {
            httpSession.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }
}
