package com.solequat.businesslogic.service;

import com.solequat.businesslogic.dto.UserDTO;
import com.solequat.businesslogic.entity.User;

public interface UserService {

    void enableUser(String email);

    User findUserByEmail(String email);

}