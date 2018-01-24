package com.p202.jsx.user;

import com.p202.jsx.user.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A controller to lookup & interact with users
 */
@RequestMapping("users")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    List<UserResponseDto> getUsers() {
        return userService.getUsers();
    }

}
