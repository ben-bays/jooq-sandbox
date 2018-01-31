package com.p202.jsx.photo.impl;

import com.p202.jsx.photo.PhotoService;
import com.p202.jsx.photo.dao.PhotoDao;
import com.p202.jsx.photo.dto.PhotoMapper;
import com.p202.jsx.photo.dto.PhotoResponseDto;
import com.p202.jsx.user.UserService;
import com.p202.jsx.user.dto.UserResponseDto;
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
    private final PhotoMapper photoMapper;

    @Autowired
    public PhotoServiceImpl(final UserService userService, final PhotoDao photoDao, final PhotoMapper photoMapper) {
        this.userService = userService;
        this.photoDao = photoDao;
        this.photoMapper= photoMapper;
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

        return photoDao.getPhotosByUser(userId)
                .stream()
                .map(record -> photoMapper.recordToDto(record, user.getId(), user.getEmail()))
                .collect(Collectors.toList());
    }
}
