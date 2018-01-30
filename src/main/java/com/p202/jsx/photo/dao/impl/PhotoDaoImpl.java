package com.p202.jsx.photo.dao.impl;

import com.p202.jsx.jooq.core.tables.records.PhotoRecord;
import com.p202.jsx.photo.dao.PhotoDao;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.p202.jsx.jooq.core.tables.Photo.PHOTO;
import static com.p202.jsx.jooq.iam.tables.User.USER;

@Repository
public class PhotoDaoImpl implements PhotoDao {

    private final DSLContext create;

    @Autowired
    public PhotoDaoImpl(final DSLContext create) {
        this.create = create;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PhotoRecord> getPhotosByUser(final long userId) {
        return create
                .select(PHOTO.ID, PHOTO.DESCRIPTION, PHOTO.CREATED_DATE, PHOTO.OWNER_ID)
                .from(PHOTO)
                .join(USER).onKey()
                .where(PHOTO.OWNER_ID.eq(userId))
                .fetch()
                .into(PhotoRecord.class);
    }
}
