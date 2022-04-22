package com.itheima.service.imp;

import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.dao.imp.RoleDaoService;
import com.itheima.dao.imp.UerDaoService;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/4/16 17:37
 * @description：
 * @modified By：
 * @version: $
 */
public class UserServiceImp implements UserService {
    public UserDao userDao;
    public RoleDao roleDao;

    public List<User> list() {
        List<User> userList = userDao.list();
        userList.forEach((user) -> {
            Long id = user.getId();
            List<Role> roleList = roleDao.findRoleByUserId(id);
            user.setRoleList(roleList);
        });
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        Long userId = userDao.save(user);
        userDao.userRoleRealation(userId,roleIds);
    }

    @Override
    public void del(Long userId) {
        userDao.delRoleRealtion(userId);
        userDao.del(userId);
    }

    @Override
    public User login(String username,String password) {
        try{
            User user = userDao.findUser(username,password);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
