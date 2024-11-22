package com.lucas.blockchain.domain.service;

import com.lucas.blockchain.application.dto.UserDTO;
import com.lucas.blockchain.application.mappers.UserMapper;
import com.lucas.blockchain.domain.entity.User;
import com.lucas.blockchain.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        log.info("Saving user {}", user);
        return userRepository.save(user);
    }

    public Page<User> findAll(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    public Page<User> findByUsername(String username, Pageable pageable) {
        return this.userRepository.findByUsername(username, pageable);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
