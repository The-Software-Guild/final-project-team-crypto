package com.mthree.cryptoinvesting.data;

import com.mthree.cryptoinvesting.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Kristi
 * @version 11/19/2021
 */

@Repository
public class UserDaoDatabaseImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Users addUser(Users user) {
        final String SQL_INSERT_USER = "INSERT INTO user(username, password) VALUES (?,?)" ;
        jdbcTemplate.update(SQL_INSERT_USER, user.getUsername(), user.getPassword());

        int newUserId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        user.setUserId(newUserId);

        return user;
    }

    @Override
    public List<Users> getAllUsers() {
        final String SQL_SELECT_ALL_USERS = "SELECT * FROM user";
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, new UserMapper());
    }

    @Override
    public Users getUserByName(String username) {
        final String SQL_SELECT_USER_BY_NAME = "SELECT * FROM user WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_NAME, new UserMapper(), username);
        } catch (DataAccessException ex) {
            return new Users("Error", "User Not Found");
        }
    }


    @Override
    public boolean deleteUser(Users user) {
        int userId = user.getUserId();
        final String SQL_DELETE_USER_BY_ID = "DELETE FROM user WHERE userId = ?";
        return jdbcTemplate.update(SQL_DELETE_USER_BY_ID, userId) > 0;
    }

    public static final class UserMapper implements RowMapper<Users> {

        @Override
        public Users mapRow(ResultSet rs, int index) throws SQLException {

            Users user = new Users();
            user.setUserId(rs.getInt("userId"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;

        }

    }

}
