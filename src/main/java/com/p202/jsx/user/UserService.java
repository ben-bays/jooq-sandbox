package com.p202.jsx.user;

import com.p202.jsx.user.dto.UserResponseDto;

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

    /**
     * Retrievec a single user from the database by its primary key
     * @param userId The primary key of the user to lookup
     * @return {@link UserResponseDto} information on the user.
     */
    UserResponseDto getUser(final long userId);
}
