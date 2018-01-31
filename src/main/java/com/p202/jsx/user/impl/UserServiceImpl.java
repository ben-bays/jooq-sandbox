package com.p202.jsx.user.impl;

import com.p202.jsx.jooq.iam.tables.records.UserRecord;
import com.p202.jsx.user.UserService;
import com.p202.jsx.user.dao.UserDao;
import com.p202.jsx.user.dto.UserMapper;
import com.p202.jsx.user.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(final UserDao userDao, final UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserResponseDto> getUsers() {

        final List<UserRecord> userRecords = userDao.getUsers();

        return userRecords.stream()
                .map(userMapper::recordToDto)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserResponseDto getUser(final long userId) {
        final UserRecord userRecord = userDao.getUser(userId);
        return userMapper.recordToDto(userRecord);
    }
}
