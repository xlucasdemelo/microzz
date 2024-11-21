package com.lucas.blockchain.application.mappers;

import com.lucas.blockchain.application.dto.UserDTO;
import com.lucas.blockchain.domain.entity.User;

public class UserMapper {
    public static User toEntity(UserDTO userDTO) {
        return new User(null, userDTO.username(), userDTO.password());
    }
}