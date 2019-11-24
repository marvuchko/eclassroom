package com.elfak.eclassroom.dto.user;

import com.elfak.eclassroom.dto.base.BaseDto;

public class UserDto extends BaseDto {

    private String fullName;

    private String email;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
