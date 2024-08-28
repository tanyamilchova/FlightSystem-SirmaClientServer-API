package com.sirma.tanyamilchova.demo.repository;



import com.sirma.tanyamilchova.demo.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    public Optional<UserInfo> findByUsername(String username);
}

