package com.itheima.dao.imp;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/4/16 17:38
 * @description：
 * @modified By：
 * @version: $ 应该叫UserdaoImp
 */
public class UerDaoService implements UserDao {
    public JdbcTemplate jdbcTemplate;
    public List<User> list() {
        return jdbcTemplate.query("select * from sys_user",new BeanPropertyRowMapper<User>(User.class));
    }

    @Override // 返回自增id
    public Long save(User user) {
        //jdbcTemplate.update("insert sys_user values (?,?,?,?)",null,user.getUsername(),user.getEmail(),user.getPassword(),user.getPhoneNum());
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement("insert sys_user values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhoneNum());
                return preparedStatement;
            }
        };
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator, keyHolder);
        long userid = keyHolder.getKey().longValue();
        return userid;
    }

    @Override
    public void userRoleRealation(Long id, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values (?,?)", id, roleId);
        }
    }

    @Override
    public void del(Long userId) {
           jdbcTemplate.update("delete from sys_user where id = ?" ,userId);

    }

    @Override
    public void delRoleRealtion(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId = ?" ,userId);
    }

    @Override
    public User findUser(String username, String password) throws EmptyResultDataAccessException {
        User user = jdbcTemplate.queryForObject("select * from sys_user where username = ? and password = ?",new BeanPropertyRowMapper<>(User.class),username,password);
        return user;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
