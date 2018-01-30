package com.p202.jsx.user.impl;

import com.p202.jsx.jooq.iam.tables.records.UserRecord;
import com.p202.jsx.user.UserService;
import com.p202.jsx.user.dao.UserDao;
import com.p202.jsx.user.dto.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(
            final UserDao userDao,
            final ModelMapper mapper) {
        this.userDao = userDao;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserResponseDto> getUsers() {

        final List<UserRecord> userRecords = userDao.getUsers();

        return userRecords.stream()
                .map(r -> mapper.map(r, UserResponseDto.class))
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserResponseDto getUser(final long userId) {
        final UserRecord userRecord = userDao.getUser(userId);
        return userRecord != null ? mapper.map(userRecord, UserResponseDto.class) : null;
    }
}
