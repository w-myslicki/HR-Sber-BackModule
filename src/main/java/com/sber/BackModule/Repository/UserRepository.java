package com.sber.BackModule.Repository;

import com.sber.BackModule.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
