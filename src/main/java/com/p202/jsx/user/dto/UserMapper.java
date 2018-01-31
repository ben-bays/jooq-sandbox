package com.p202.jsx.user.dto;

import com.p202.jsx.jooq.iam.tables.records.UserRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDto recordToDto(final UserRecord record);

}
