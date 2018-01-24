package com.p202.jsx.user.dto;

import java.util.Objects;

public class UserResponseDto {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserResponseDto)) return false;
        UserResponseDto userResponseDto = (UserResponseDto) o;
        return Objects.equals(id, userResponseDto.id) &&
                Objects.equals(email, userResponseDto.email) &&
                Objects.equals(firstName, userResponseDto.firstName) &&
                Objects.equals(lastName, userResponseDto.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, firstName, lastName);
    }
}
