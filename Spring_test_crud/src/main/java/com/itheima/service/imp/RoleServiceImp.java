package com.itheima.service.imp;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;

import java.util.List;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/4/16 15:31
 * @description：
 * @modified By：
 * @version: $
 */
public class RoleServiceImp implements RoleService {
    private RoleDao roleDao;

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> list() {
        return roleDao.findAll();
    }

    public void save(Role role) {
        roleDao.save(role);
    }
}
