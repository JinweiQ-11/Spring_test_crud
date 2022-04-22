package com.itheima.dao.imp;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/4/16 15:33
 * @description：
 * @modified By：
 * @version: $
 */
public class RoleDaoService implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Role> findAll() {
        List<Role>roleList = jdbcTemplate.query("select * from sys_role",new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values (?,?,?)",null,role.getRoleName(),role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleByUserId(Long id) {
        return jdbcTemplate.query("select * from sys_user_role as A inner join sys_role as B on A.roleId = B.id where A.userId = ?",new BeanPropertyRowMapper<>(Role.class),id);
    }

    @Override
    public void userRoleRealation(Long id, Long[] roleIds) {

    }
}
