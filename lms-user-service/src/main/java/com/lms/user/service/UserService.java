package com.lms.user.service;

import com.lms.user.dto.UserDTO;
import com.lms.user.model.User;

public interface UserService {
    User createUser(UserDTO userDTO);
    User updateUser(Long userId, UserDTO userDTO);
    User getUserById(Long userId);
}
