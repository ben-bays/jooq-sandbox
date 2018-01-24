package com.p202.jsx.photo;


import com.p202.jsx.photo.dto.PhotoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
