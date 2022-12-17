package com.cursor.cursor.repository;

import com.cursor.cursor.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByName(String userName);

    List<UserEntity> findByRoles(String roles);
}
