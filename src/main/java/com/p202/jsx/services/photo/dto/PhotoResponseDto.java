package com.p202.jsx.services.photo.dto;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Response that includes metadata of a photo along with the user that created it
 */
public class PhotoResponseDto {

    private Long id;

    private LocalDateTime createdAt;

    private String description;

    private Long ownerId;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhotoResponseDto)) return false;
        PhotoResponseDto that = (PhotoResponseDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(description, that.description) &&
                Objects.equals(ownerId, that.ownerId) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, description, ownerId, email);
    }
}
