package com.p202.jsx.user.dto;

import com.p202.jsx.jooq.iam.tables.records.UserRecord;
import com.p202.jsx.shared.mapstruct.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Provide translation between User records and DTOs
 * @author Ben Bays <ben.bays@projekt202.com>
 */
@Mapper(config = MapStructConfig.class)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDto recordToDto(final UserRecord record);

}
