package com.p202.jsx.services.photo.impl;

import com.p202.jsx.jooq.core.tables.records.PhotoRecord;
import com.p202.jsx.jooq.iam.tables.records.UserRecord;
import com.p202.jsx.services.photo.PhotoService;
import com.p202.jsx.services.photo.dto.PhotoResponseDto;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.p202.jsx.jooq.core.tables.Photo.PHOTO;
import static com.p202.jsx.jooq.iam.tables.User.USER;

/**
 * @author Ben Bays <ben.bays@projekt202.com>
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    private final DSLContext create;

    @Autowired
    public PhotoServiceImpl(final DSLContext create) {
        this.create = create;
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

        final List<PhotoResponseDto> photoResponse = new ArrayList<>();

        for (final Record record : userPhotoRecords) {
            final PhotoRecord photoRecord = record.into(PHOTO);
            final UserRecord userRecord = record.into(USER);

            final PhotoResponseDto dto = new PhotoResponseDto();
            dto.setCreatedAt(photoRecord.getCreatedDate().toLocalDateTime());
            dto.setDescription(photoRecord.getDescription());
            dto.setEmail(userRecord.getEmail());
            dto.setId(photoRecord.getId());
            dto.setOwnerId(userRecord.getId());
            photoResponse.add(dto);
        }


        return photoResponse;
    }
}
