package com.softtech.bootcamp.case3.response.user;

import com.softtech.bootcamp.case3.enums.UserType;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private UserType type;
}
