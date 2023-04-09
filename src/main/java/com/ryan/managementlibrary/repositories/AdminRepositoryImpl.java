package com.ryan.managementlibrary.repositories;

import com.ryan.managementlibrary.models.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class AdminRepositoryImpl implements AdminRepository{

    private final JdbcTemplate jdbcTemplate;

    public AdminRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User findByUsername(String username) {
        String sqlFindByUsername = "SELECT * FROM t_admin WHERE username = ?";
        return null;
    }
}
