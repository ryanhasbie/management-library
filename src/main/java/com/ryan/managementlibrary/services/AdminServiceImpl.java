package com.ryan.managementlibrary.services;

import com.ryan.managementlibrary.models.Admin;
import com.ryan.managementlibrary.repositories.AdminRepository;
import org.springframework.dao.DataAccessException;

public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Boolean login(String username, String password) {
       try {
           Admin admin = adminRepository.findByUsername(username);
           if (admin != null && admin.getPassword().equals(password)) {
               return true;
           }
           return false;
       } catch (Exception e) {
           throw new RuntimeException();
       }
    }
}
