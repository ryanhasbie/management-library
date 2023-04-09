package com.ryan.managementlibrary.repositories;

import com.ryan.managementlibrary.models.Admin;
import com.ryan.managementlibrary.models.User;
import com.ryan.managementlibrary.models.mappers.AdminMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class AdminRepositoryImpl implements AdminRepository{

    private final JdbcTemplate jdbcTemplate;

    public AdminRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Admin findByUsername(String username) throws Exception {
        try {
            String sqlFindByUsername = "SELECT * FROM t_admin WHERE username = ?";
            return jdbcTemplate.queryForObject(sqlFindByUsername, new AdminMapper(), new Object[]{username});
        } catch (DataAccessException e) {
            throw new Exception();
        }
    }
}
