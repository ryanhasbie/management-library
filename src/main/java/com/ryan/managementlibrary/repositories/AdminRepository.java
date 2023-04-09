package com.ryan.managementlibrary.repositories;

import com.ryan.managementlibrary.models.User;

public interface AdminRepository {
    User findByUsername(String username);
}
