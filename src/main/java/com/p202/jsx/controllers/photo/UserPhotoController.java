package com.p202.jsx.controllers.photo;


import com.p202.jsx.services.photo.PhotoService;
import com.p202.jsx.services.photo.dto.PhotoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/{userId}/photos")
public class UserPhotoController {

    private final PhotoService photoService;

    @Autowired
    public UserPhotoController(final PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public List<PhotoResponseDto> getPhotosByOwner(@PathVariable("userId") final long userId) {
        return photoService.getPhotosByUserId(userId);
    }

}
