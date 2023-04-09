package com.ryan.managementlibrary.repositories;

import com.ryan.managementlibrary.models.Admin;

public interface AdminRepository {
    Admin findByUsername(String username) throws Exception;
}
