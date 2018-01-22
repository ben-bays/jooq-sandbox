package com.p202.jsx.services.user;

import com.p202.jsx.services.user.dto.UserResponseDto;

import java.util.List;

/**
 * Service for looking up and interacting with users
 */
public interface UserService {

    /**
     * Get all available users from the database
     * @return {@link List} of {@link UserResponseDto}
     */
    List<UserResponseDto> getUsers();
}
