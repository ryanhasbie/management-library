package com.ryan.managementlibrary.repositories;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.models.User;
import com.ryan.managementlibrary.models.mappers.UserMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository{

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<User> getAll() throws Exception {
        try {
             String sqlGetAll = "SELECT * FROM t_user";
            return jdbcTemplate.query(sqlGetAll, new UserMapper());
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public User create(User user) throws Exception {
        try {
            String sqlInsert = "INSERT iNTO t_user(name, phone_number, address) VALUES(?,?,?)";
            int result = jdbcTemplate.update(sqlInsert, user.getName(), user.getPhoneNumber(), user.getAddress());
            if (result <= 0) {
                throw new Exception("Failed create user!");
            }
            return user;
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<User> findById(Integer id) throws Exception {
        try {
            String sqlFindById = "SELECT * FROM t_user WHERE user_id = ?";
            User user = jdbcTemplate.queryForObject(sqlFindById, new UserMapper(), new Object[]{id});
            return Optional.ofNullable(user);
        } catch (DataAccessException e) {
            throw new Exception("Id User Not Found!");
        }
    }

    @Override
    public void update(User user, Integer id) throws Exception {
        try {
            String sqlUpdate = "UPDATE t_user SET name = ?, phone_number = ?, address = ? WHERE user_id = ?";
            jdbcTemplate.update(sqlUpdate, user.getName(), user.getPhoneNumber(), user.getAddress(), id);
        } catch (DataAccessException e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            String sqlDelete = "DELETE FROM t_user WHERE user_id = ?";
            jdbcTemplate.update(sqlDelete, id);
        } catch (DataAccessException e) {
            throw new Exception(e.getMessage());
        }
    }
}
