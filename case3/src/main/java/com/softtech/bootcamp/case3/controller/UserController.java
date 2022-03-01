package com.softtech.bootcamp.case3.controller;

import com.softtech.bootcamp.case3.response.RestResponse;
import com.softtech.bootcamp.case3.response.user.UserDeleteRequest;
import com.softtech.bootcamp.case3.response.user.UserResponse;
import com.softtech.bootcamp.case3.response.user.UserSaveRequest;
import com.softtech.bootcamp.case3.response.user.UserUpdateRequest;
import com.softtech.bootcamp.case3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity save(@RequestBody UserSaveRequest userSaveRequest){
        return ResponseEntity.ok(RestResponse.of(userService.save(userSaveRequest)));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(RestResponse.of(userService.findById(id)));
    }

    @GetMapping("/username")
    public ResponseEntity findByUsername(@RequestParam("username") String username){
        return ResponseEntity.ok(RestResponse.of(userService.findByUsername(username)));
    }

    @DeleteMapping
    public ResponseEntity deleteById(@RequestBody UserDeleteRequest userDeleteRequest){
        return ResponseEntity.ok(RestResponse.of(userService.deleteById(userDeleteRequest)));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody UserUpdateRequest userUpdateRequest){
        return ResponseEntity.ok(RestResponse.of(userService.update(userUpdateRequest)));
    }

}
