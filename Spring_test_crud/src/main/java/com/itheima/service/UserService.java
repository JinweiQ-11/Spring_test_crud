package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/4/16 17:35
 * @description：
 * @modified By：
 * @version: $
 */
public interface UserService {
    public List<User> list();

    void save(User user,Long[] roleIds);

    void del(Long userId);

    User login(String username,String password);
}
