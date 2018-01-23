package com.p202.jsx.services.photo.impl;

import com.p202.jsx.services.photo.PhotoService;
import com.p202.jsx.services.photo.dto.PhotoResponseDto;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.p202.jsx.jooq.core.tables.Photo.PHOTO;
import static com.p202.jsx.jooq.iam.tables.User.USER;

/**
 * @author Ben Bays <ben.bays@projekt202.com>
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    private final DSLContext create;
    private final ModelMapper mapper;

    @Autowired
    public PhotoServiceImpl(final DSLContext create, final ModelMapper mapper) {
        this.create = create;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PhotoResponseDto> getPhotosByUserId(final long userId) {

        final Result<Record> userPhotoRecords = create
                .select()
                .from(PHOTO)
                .join(USER).onKey()
                .where(PHOTO.OWNER_ID.eq(userId))
                .fetch();

        return userPhotoRecords.stream()
                .map(record -> mapper.map(record, PhotoResponseDto.class))
                .collect(Collectors.toList());

    }
}
