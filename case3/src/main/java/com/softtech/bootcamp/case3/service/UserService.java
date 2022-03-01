package com.softtech.bootcamp.case3.service;

import com.softtech.bootcamp.case3.converter.ProductMapper;
import com.softtech.bootcamp.case3.converter.UserMapper;
import com.softtech.bootcamp.case3.enums.errormessage.DuplicateErrorException;
import com.softtech.bootcamp.case3.enums.errormessage.NotFoundErrorMessage;
import com.softtech.bootcamp.case3.exception.DuplicateException;
import com.softtech.bootcamp.case3.exception.NotFoundException;
import com.softtech.bootcamp.case3.model.Product;
import com.softtech.bootcamp.case3.model.User;
import com.softtech.bootcamp.case3.repository.UserRepository;
import com.softtech.bootcamp.case3.response.user.UserDeleteRequest;
import com.softtech.bootcamp.case3.response.user.UserResponse;
import com.softtech.bootcamp.case3.response.user.UserSaveRequest;
import com.softtech.bootcamp.case3.response.user.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse save(UserSaveRequest userSaveRequest) {
        boolean isExistsByUsername = userRepository.existsByUsername(userSaveRequest.getUsername());
        boolean isExistsByEmail = userRepository.existsByEmail(userSaveRequest.getEmail());
        boolean isExistsByPhoneNumber = userRepository.existsByPhoneNumber(userSaveRequest.getPhoneNumber());
        if(!isExistsByUsername && !isExistsByEmail && !isExistsByPhoneNumber){
            User user = UserMapper.INSTANCE.toUserFromUserSaveRequest(userSaveRequest);
            return UserMapper.INSTANCE.toUserResponseFromUser(userRepository.save(user));
        }
        throw new DuplicateException(DuplicateErrorException.USER_DUPLICATE_ERROR_EXCEPTION);
    }

    public UserResponse findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException(NotFoundErrorMessage.USER_NOT_FOUND_BY_ID_ERROR_MESSAGE));
        return UserMapper.INSTANCE.toUserResponseFromUser(user);
    }


    public UserResponse findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new NotFoundException(NotFoundErrorMessage.USER_NOT_FOUND_BY_USERNAME_ERROR_MESSAGE));
        return UserMapper.INSTANCE.toUserResponseFromUser(user);
    }

    public UserResponse deleteById(UserDeleteRequest userDeleteRequest) {
        String username = userDeleteRequest.getUsername();
        String phoneNumber = userDeleteRequest.getPhoneNumber();
        User user = userRepository.findByUsernameAndPhoneNumber(
                username,
                phoneNumber
        ).orElseThrow(() -> new NotFoundException(String.format("%s kullanıcı adı ve %s telefon numarası eşleşmemektedir!",
                username, phoneNumber)));
        userRepository.deleteById(userDeleteRequest.getId());
        return UserMapper.INSTANCE.toUserResponseFromUser(user);
    }

    public UserResponse update(UserUpdateRequest userUpdateRequest) {
        boolean existsById = userRepository.existsById(userUpdateRequest.getId());
        if(existsById){
            User user = UserMapper.INSTANCE.toUserFromUserUpdateRequest(userUpdateRequest);
            return UserMapper.INSTANCE.toUserResponseFromUser(userRepository.save(user));
        }
        throw new NotFoundException(NotFoundErrorMessage.USER_NOT_FOUND_BY_ID_ERROR_MESSAGE);
    }
}
