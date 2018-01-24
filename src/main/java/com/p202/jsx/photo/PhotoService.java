package com.p202.jsx.photo;

import com.p202.jsx.photo.dto.PhotoResponseDto;

import java.util.List;

/**
 * Lookup Photos
 */
public interface PhotoService {

    /**
     * Retrieve all photos owned by a particular user
     * @param userId {@link Long} Owner ID of the photos to get
     * @return {@link List} of photos
     */
    List<PhotoResponseDto> getPhotosByUserId(final long userId);
}
