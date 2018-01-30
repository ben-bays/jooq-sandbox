package com.p202.jsx.photo.dao;

import com.p202.jsx.jooq.core.tables.records.PhotoRecord;

import java.util.List;

/**
 * Primary Data base object for the photo table.
 */
public interface PhotoDao {

    /**
     * Return all photos from the database that are owned by the given <code>userId</code>.
     * @param userId The ID of the photo's owner
     * @return {@link List} of {@link PhotoRecord}
     */
    List<PhotoRecord> getPhotosByUser(final long userId);

}
