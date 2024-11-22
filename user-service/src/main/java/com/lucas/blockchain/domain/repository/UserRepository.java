package com.lucas.blockchain.domain.repository;

import com.lucas.blockchain.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public Page<User> findByUsername(String username, Pageable pageable);
}
