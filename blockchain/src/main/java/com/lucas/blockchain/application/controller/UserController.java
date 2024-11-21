package com.lucas.blockchain.application.controller;

import com.lucas.blockchain.application.dto.UserDTO;
import com.lucas.blockchain.domain.entity.User;
import com.lucas.blockchain.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO){
        User user = this.userService.saveUser(userDTO);
        return ResponseEntity.ok(user);
    }
}
