package com.softtech.bootcamp.case3.converter;

import com.softtech.bootcamp.case3.model.User;
import com.softtech.bootcamp.case3.response.user.UserResponse;
import com.softtech.bootcamp.case3.response.user.UserSaveRequest;
import com.softtech.bootcamp.case3.response.user.UserUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {


    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse toUserResponseFromUser(User user);

    User toUserFromUserSaveRequest(UserSaveRequest userSaveRequest);

    User toUserFromUserUpdateRequest(UserUpdateRequest userUpdateRequest);

}
