package com.lucas.blockchain.unit.domain.service;


import com.lucas.blockchain.application.dto.UserDTO;
import com.lucas.blockchain.domain.entity.User;
import com.lucas.blockchain.domain.repository.UserRepository;
import com.lucas.blockchain.domain.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private static UserDTO sampleUser;

    @BeforeEach
    public void setUp() {
        sampleUser = new UserDTO("sample user", "passw");
    }

    @Test
    public void createUser() {
        Mockito.when(userRepository.save(any())).thenReturn(new User(1000L, sampleUser.username(), sampleUser.password()));

        User result = userService.saveUser(sampleUser);
        Assert.notNull(result, "User not saved");
        Assert.hasText(result.getUsername(), "sample user");
    }

//    @Test
//    public void createUserAssertFail_WithoutMandatoryFields() {
//        User user = new User(null, null, "passw");
//        Mockito.when(userRepository.save(user)).thenThrow(RuntimeException.class);
//
//        assertThrows(RuntimeException.class, () -> userService.saveUser(user), "User not saved");
//    }
}
