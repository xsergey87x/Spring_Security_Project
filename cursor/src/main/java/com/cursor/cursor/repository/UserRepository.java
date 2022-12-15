package com.cursor.cursor.repository;

import com.cursor.cursor.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository {

    Optional<UserEntity> findByUserName(String userName);
}
