package com.sber.BackModule.Repository;

import com.sber.BackModule.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByLogin(String login);
}
