package com.p202.jsx.photo.impl;

import com.p202.jsx.photo.PhotoService;
import com.p202.jsx.photo.dao.PhotoDao;
import com.p202.jsx.photo.dto.PhotoResponseDto;
import com.p202.jsx.user.UserService;
import com.p202.jsx.user.dto.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ben Bays <ben.bays@projekt202.com>
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    private final UserService userService;
    private final PhotoDao photoDao;
    private final ModelMapper mapper;

    @Autowired
    public PhotoServiceImpl(final UserService userService, final PhotoDao photoDao, final ModelMapper mapper) {
        this.userService = userService;
        this.photoDao = photoDao;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PhotoResponseDto> getPhotosByUserId(final long userId) {

        final UserResponseDto user = userService.getUser(userId);

        if (null == user) {
            return Collections.emptyList();
        }

        final List<PhotoResponseDto> photos = photoDao.getPhotosByUser(userId)
                .stream()
                .map(record -> mapper.map(record, PhotoResponseDto.class))
                .collect(Collectors.toList());


        photos.forEach(r -> r.setEmail(user.getEmail()));
        photos.forEach(r -> r.setOwnerId(user.getId()));

        return photos;

    }
}
