package com.p202.jsx.services.photo.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Response that includes metadata of a photo along with the user that created it
 */
public class PhotoResponseDto {

    private Long id;

    private LocalDateTime createdDate;

    private String description;

    private Long ownerId;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdAt) {
        this.createdDate = createdAt;
    }

    public void setCreatedDate(final Timestamp timestamp) {
        this.createdDate = timestamp.toLocalDateTime();
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
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(description, that.description) &&
                Objects.equals(ownerId, that.ownerId) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, description, ownerId, email);
    }
}
