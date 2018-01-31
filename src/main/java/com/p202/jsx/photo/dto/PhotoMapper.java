package com.p202.jsx.photo.dto;

import com.p202.jsx.jooq.core.tables.records.PhotoRecord;
import com.p202.jsx.shared.mapstruct.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Provide translation between photo records and photo dtos
 * @author Ben Bays <ben.bays@projekt202.com>
 */
@Mapper(config = MapStructConfig.class)
public interface PhotoMapper {

    /**
     * @return A new {@link PhotoResponseDto}
     */
    PhotoResponseDto recordToDto(
            final PhotoRecord record,
            final long ownerId,
            final String email);
}
