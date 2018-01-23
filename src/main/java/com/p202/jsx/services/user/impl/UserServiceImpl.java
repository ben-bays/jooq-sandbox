package com.p202.jsx.services.user.impl;

import com.p202.jsx.jooq.iam.tables.User;
import com.p202.jsx.jooq.iam.tables.records.UserRecord;
import com.p202.jsx.services.user.UserService;
import com.p202.jsx.services.user.dto.UserResponseDto;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final DSLContext create;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(
            final DSLContext create,
            final ModelMapper mapper) {
        this.create = create;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserResponseDto> getUsers() {

        final Result<UserRecord> allUsers = this.create
                .selectFrom(User.USER)
                .fetch();

        final List<UserResponseDto> usersResponse = new ArrayList<>();

        for (final UserRecord record : allUsers) {
            final UserResponseDto response = mapper.map(record, UserResponseDto.class);
            usersResponse.add(response);
        }

        return usersResponse;
    }
}
