package com.softtech.bootcamp.case3.response.user;

import lombok.Data;

@Data
public class UserDeleteRequest {

    Long id;
    String username;
    String phoneNumber;
}
