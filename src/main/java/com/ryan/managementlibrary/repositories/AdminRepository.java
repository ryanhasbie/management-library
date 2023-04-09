package com.ryan.managementlibrary.repositories;

import com.ryan.managementlibrary.models.Admin;
import com.ryan.managementlibrary.models.User;

public interface AdminRepository {
    Admin findByUsername(String username) throws Exception;
}
