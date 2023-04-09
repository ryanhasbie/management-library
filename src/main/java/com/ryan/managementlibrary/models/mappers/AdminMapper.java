package com.ryan.managementlibrary.models.mappers;

import com.ryan.managementlibrary.models.Admin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper implements RowMapper<Admin> {
    @Override
    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Admin admin = new Admin();
        admin.setAdminId(rs.getInt("admin_id"));
        admin.setPassword(rs.getString("username"));
        admin.setPassword(rs.getString("password"));
        return admin;
    }
}
