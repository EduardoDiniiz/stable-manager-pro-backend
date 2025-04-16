package com.graodavida.haraspro.controllers;

import com.graodavida.haraspro.entities.User;
import com.graodavida.haraspro.request.UserCreateRequest;
import com.graodavida.haraspro.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserCreateRequest> createUser(@RequestBody UserCreateRequest user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
}
