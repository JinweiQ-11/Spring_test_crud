package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {
    List<User> list();

    Long save(User user);

    void userRoleRealation(Long id, Long[] roleIds);

    void del(Long userId);

    void delRoleRealtion(Long userId);

    User findUser(String username, String password);
}
